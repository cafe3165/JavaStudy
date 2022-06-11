package com.example.leetcode.leetcode_daily.May;

import java.util.List;
import java.util.Stack;

/**
 * Author:cafe3165
 * Date:2020-05-16
 */
public class T25reverseKGroup {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start = dummy;
        ListNode end = head;
        int count = 0;
        while (end != null) {
            count++;
            // group
            if (count % k == 0) {
                // reverse linked list (start, end]
                start = reverse(start, end.next);
                end = start.next;
            } else {
                end = end.next;
            }
        }
        return dummy.next;

    }
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode curr = start.next;
        ListNode prev = start;
        ListNode first = curr;
        while (curr != end){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        start.next = prev;
        first.next = curr;
        return first;
    }


    public static void main(String[] args) {
        ListNode root = gen();
        int k = 2;
        T25reverseKGroup t=new T25reverseKGroup();
        root = t.reverseKGroup(root, k);
        while (root != null) {
            System.out.print(root.val);
            root = root.next;
        }

    }

    public static ListNode gen() {
        ListNode root = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        root.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return root;


    }
}
