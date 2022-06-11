package com.example.leetcode.leetcode_M;

/**
 * Author:cafe3165
 * Date:2020-11-01
 */
public class T138copyRandomList {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;

        while (p != null) {
            Node node = new Node(p.val);
            node.next = p.next;
            p.next = node;
            p = node.next;
        }
        p = head;
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        p = head.next;
        Node q= head;
        Node newHead = p;
        while (p.next != null) {
            q.next = p.next;
            p.next = p.next.next;
            p = p.next;
            q = q.next;
        }
        q.next = p.next;
        return newHead;
    }

    public static Node gen() {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2;
        n1.random = null;
        n2.next = n3;
        n2.random = n1;
        n3.next = n4;
        n3.random = n5;
        n4.next = n5;
        n4.random = n3;
        n5.next = null;
        n5.random = n1;
        return n1;
    }

    public static void main(String[] args) {

        copyRandomList(gen());
    }
}
