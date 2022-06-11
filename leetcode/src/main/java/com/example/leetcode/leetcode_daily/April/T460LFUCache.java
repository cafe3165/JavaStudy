package com.example.leetcode.leetcode_daily.April;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-04-05
 */
public class T460LFUCache {

    Map<Integer, Node> cache;
    Map<Integer, LinkedHashSet<Node>> fre;
    int capacity;
    int size;
    int min;

    //    记得改名字
    public T460LFUCache(int capacity) {
        cache = new HashMap<>(capacity);
        fre = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        freqInc(node);
        return node.value;
    }

    private void freqInc(Node node) {
        int freq = node.freq;
        LinkedHashSet<Node> set = fre.get(freq);

        set.remove(node);
        System.out.println(set.size() == 0);
        if ((freq == min) && (set.size() == 0))
        {
            min = freq + 1;
        }
        node.freq++;
        LinkedHashSet newset = fre.get(node.freq);
        if (newset == null) {
            newset = new LinkedHashSet<>();
            fre.put(node.freq, newset);
        }
        newset.add(node);


    }

    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        Node node = cache.get(key);
        if (node != null) {
            node.value = value;
            freqInc(node);
        } else {
            if (size == capacity) {
//                移除频次最少的点
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    private void addNode(Node newNode) {
//        取出频次为1的结点集合
        LinkedHashSet<Node> set = fre.get(1);
//        初始化
        if (set == null) {
            set = new LinkedHashSet<>();
            fre.put(1, set);
        }
        set.add(newNode);
        min = 1;
    }

    private Node removeNode() {
        LinkedHashSet<Node> set = fre.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }

    class Node {
        int key;
        int value;
        int freq = 1;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }


    public static void main(String[] args) {
        int capacity = 2;
        T460LFUCache cache = new T460LFUCache(capacity);
        cache.put(1, 1);
        cache.put(2, 2);
        int t;
        t=cache.get(1);       // 返回 1
        cache.put(3, 3);    // 去除 key 2
        t=cache.get(2);       // 返回 -1 (未找到key 2)
        t=cache.get(3);       // 返回 3
        cache.put(4, 4);    // 去除 key 1
        t=cache.get(1);       // 返回 -1 (未找到 key 1)
        t=cache.get(3);       // 返回 3
        t=cache.get(4);       // 返回 4


    }
}
