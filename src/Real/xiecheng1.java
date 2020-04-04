package Real;

/**
 * Author:cafe3165
 * Date:2020-03-31
 */


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class xiecheng1{
private class Node {
    Node next, prev;
    int key, value;

    Node (){}
    Node(int key, int value) {
        this.value = value;
        this.key = key;
    }
}

    private Node head, tail;
    private Map<Integer, Node> map;
    private int count, capacity;

    private void addNode(Node node) {
        Node old = head.next;
        head.next = node;
        node.prev = head;
        node.next = old;
        old.prev = node;
    }

    private void removeNode(Node node) {
        Node previous = node.prev;
        previous.next = node.next;
        node.next.prev = previous;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    private Node popTail() {
        Node pre = tail.prev;
        removeNode(pre);
        return pre;
    }

    public xiecheng1(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node == null) {
            if (count == capacity) {
                map.remove(popTail().key);
                --count;
            }
            Node fresh = new Node(key, value);
            map.put(key, fresh);
            addNode(fresh);
            count++;
        } else {
            node.value = value;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine().trim());
        xiecheng1 instance = new xiecheng1(capacity);
        while (scanner.hasNextLine()) {
            char o=scanner.next().charAt(0);
            int ind=scanner.nextInt();
            if (capacity >0 &&o == 'p') {
                int key = ind;
                int value = scanner.nextInt();
                instance.put(key, value);
            }else if(o == 'g') {
                if (capacity <= 0) {
                    System.out.println(-1);
                }else {
                    int key = ind;
                    System.out.println(instance.get(key));
                }
            }
        }
    }
}