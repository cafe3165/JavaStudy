package com.example.leetcode.leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-06-22
 */
public class T116connect {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


    public Node connect(Node root) {
        dfs(root, null);
        return root;

    }

    public void dfs(Node root, Node next) {
        if (root != null) {
            root.next = next;
            dfs(root.left, root.right);
            dfs(root.right, root.next != null ? root.next.left : null);
        }
    }


    public Node gen() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        return n1;
    }

    public static void main(String[] args) {
        T116connect t = new T116connect();
        t.connect(t.gen());
    }
}
