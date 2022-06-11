package com.example.leetcode.leetcode_list200;

import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-06-05
 */
public class T61rotateRight {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy, q = dummy;
        int len=0;
        while(p.next!=null){
            len++;
            p=p.next;
        }
        k=(k>len?k%len:k);
        if(k==0){
            return head;
        }
        p=dummy;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }


        ListNode newHead = new ListNode(-1);
        newHead.next = q.next;
        q.next = null;
        p.next = dummy.next;
        return newHead.next;

    }

    private static ListNode gen() {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n1;

    }

    public static void main(String[] args) {
        rotateRight(gen(), 10);

    }
}
