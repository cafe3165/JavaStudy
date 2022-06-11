package com.example.leetcode.leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-05-26
 */
public class T141hasCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || slow == null) {
                return false;
            } else {
                slow = slow.next;
                fast = fast.next;
                if (fast == null) {
                    return false;
                }
                fast = fast.next;
            }

        } while (fast != slow);

        return true;


    }

    private static ListNode gen() {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        return n1;

    }

    public static void main(String[] args) {
        hasCycle(gen());

    }
}
