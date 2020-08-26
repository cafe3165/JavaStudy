package labuladong.HighFrequnt;

import J2SE.codeblock.D;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {
    private int capacity;
    Map<Integer, Node> map = new HashMap<>(capacity);

    class Node {
        int key, val;
        Node pre, next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

    }

    class DoubleList {
        public Node head, tail;
        public int l;

        public DoubleList() {
            head = new Node(-1, -1);
            tail = new Node(-2, -2);
            head.next = tail;
            head.pre = null;
            tail.pre = head;
            tail.next = null;
            l = 0;
        }

        //         在链表头部添加节点 x，时间 O(1)
        public void addFirst(Node x) {
            x.next = head.next;
            head.next = x;
            x.next.pre = x;
            x.pre = head;
            l++;

        }

        //         删除链表中的 x 节点（x 一定存在）
//         由于是双链表且给的是目标 Node 节点，时间 O(1)
        public void remove(Node x) {
            x.next.pre = x.pre;
            x.pre.next = x.next;
            l--;
        }

        //         删除链表中最后一个节点，并返回该节点，时间 O(1)
        public Node removeLast() {
            Node node = tail.pre;
            tail.pre = node.pre;
            node.pre.next = tail;
            l--;
            return node;
        }

        //         返回链表长度，时间 O(1)
        public int size() {
            return l;
        }
    }

    DoubleList doubleList = new DoubleList();

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        } else {
            Node node = map.get(key);
            doubleList.remove(node);
            doubleList.addFirst(node);
            return node.val;
        }
    }


    public void put(int key, int val) {
        if (map.containsKey(key)) {
            Node node = new Node(key, val);
            doubleList.remove(map.get(key));
            map.remove(node.key);
            doubleList.addFirst(node);
            map.put(key,node);
        } else {
            if (doubleList.size() == capacity) {
                Node node=doubleList.removeLast();
                map.remove(node.key);
            }
            Node node = new Node(key, val);
            map.put(key, node);
            doubleList.addFirst(node);

        }
    }


    public LRUCache(int capacity) {
        this.capacity = capacity;
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
//// 你可以把 cache 理解成一个队列
//// 假设左边是队头，右边是队尾
//// 最近使用的排在队头，久未使用的排在队尾
//// 圆括号表示键值对 (key, val)
//
        cache.put(2, 1);
//// cache = [(1, 1)]
        cache.put(2, 2);
//// cache = [(2, 2), (1, 1)]
        System.out.println(cache.get(2));       // 返回 1
//// cache = [(1, 1), (2, 2)]
//// 解释：因为最近访问了键 1，所以提前至队头
//// 返回键 1 对应的值 1
        cache.put(3, 3);
//// cache = [(3, 3), (1, 1)]
//// 解释：缓存容量已满，需要删除内容空出位置
//// 优先删除久未使用的数据，也就是队尾的数据
//// 然后把新的数据插入队头
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
//// cache = [(3, 3), (1, 1)]
//// 解释：cache 中不存在键为 2 的数据
        cache.put(1, 4);
//// cache = [(1, 4), (3, 3)]
//// 解释：键 1 已存在，把原始值 1 覆盖为 4
//// 不要忘了也要将键值对提前到队头

        LinkedList linkedList= new LinkedList<>();
    }


}
