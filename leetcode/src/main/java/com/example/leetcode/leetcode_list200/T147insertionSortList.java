package com.example.leetcode.leetcode_list200;

public class T147insertionSortList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
//        -1->5->3->4->0
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode cur = head;
        ListNode tmp = null;
        while (cur != null && cur.next != null) {
            if (cur.val <= cur.next.val) {
                cur = cur.next;
            } else {
                tmp = cur.next;
                cur.next = cur.next.next;
                ListNode pre = dummyHead;
                while (pre != null && pre.next != null && pre.next.val <= tmp.val) {
                    pre = pre.next;
                }
                tmp.next = pre.next;
                pre.next = tmp;
            }
        }
        return dummyHead.next;
    }

    public static ListNode gen() {
        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(0);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;
    }

    public static void main(String[] args) {
        insertionSortList(gen());
    }
}
