package com.example.leetcode.leetcode_list200;

public class T21_mergeTwoLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode prehead = new ListNode(-1);
        ListNode pre = prehead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;

        }

        pre.next = l1==null?l2:l1;

        return prehead.next;
    }

    public ListNode gen1() {
        ListNode n1, n2, n3;
        n1 = new ListNode(1);
        n2 = new ListNode(2);
        n3 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        return n1;
    }

    public ListNode gen2() {
        ListNode n1, n2, n3, n4, n5;
        n1 = new ListNode(1);
        n2 = new ListNode(3);
        n3 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        return n1;
    }

    public static void main(String[] args) {
        T21_mergeTwoLists t = new T21_mergeTwoLists();
        ListNode n1 = t.gen1();
        ListNode n2 = t.gen2();


        t.mergeTwoLists(n1, n2);
    }
}
