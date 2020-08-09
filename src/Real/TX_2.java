package Real;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:cafe3165
 * Date:2020-08-06
 */
public class TX_2 {
    class LRUCache {
        private int capacity;

        class Node {
            int val;
            Node pre;
            Node next;

            public Node(int val) {
                this.val = val;
            }
        }

        class NodeList {
            public Node head;
            public Node tail;
            int len;

            public NodeList(Node h, Node t, int len) {
                head = h;
                tail = t;
                head.next = tail;
                tail.pre = head;
                this.len = len;
            }


            public void addFirst(Node node) {
                node.next = head.next;
                head.next = node;
                node.pre = head;
                node.next.pre = node;
                map.put(node.val, node);
                len++;
            }

            public void remove(Node node) {
                node.pre.next = node.next;
                node.next.pre = node.pre;
                map.remove(node.val);
                len--;
            }

            public void removeLast() {
                Node node = tail.pre;
                node.pre.next = tail;
                tail.pre = node.pre;
                map.remove(node.val);
                len--;
            }
        }

        Map<Integer, Node> map = new HashMap<>();
        NodeList nodelist;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            Node head = new Node(-1);
            Node tail = new Node(-2);
            nodelist = new NodeList(head, tail, 0);
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                nodelist.remove(node);
                nodelist.addFirst(node);
                return node.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if (nodelist.len >= capacity) {
                nodelist.removeLast();
                Node node = new Node(value);
                nodelist.addFirst(node);
            } else {
                if (map.containsKey(key)) {
                    Node node = map.get(key);
                    nodelist.remove(node);
                    Node newnode = new Node(value);
                    nodelist.addFirst(newnode);
                } else {
                    Node node = new Node(value);
                    nodelist.addFirst(node);
                }
            }
        }
    }

    ;

    public static void main(String[] args) {
        TX_2 tx = new TX_2();
        LRUCache cache = tx.new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);


        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }

}
