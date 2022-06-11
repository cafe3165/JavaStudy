package com.example.leetcode.leetcode_M;

import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-04-15
 */
public class T160getIntersectionNode {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        int l1 = 1, l2 = 1;
        ListNode p1 = headA, p2 = headB;
        while (p1.next != null) {
            l1++;
            p1 = p1.next;
        }
        while (p2.next != null) {
            l2++;
            p2 = p2.next;
        }
        if (p1 != p2) {
            return null;
        }
        int del = l1 - l2 ;
        p1 = headA;
        p2 = headB;
        if (del > 0) {
            while (del > 0) {
                p1 = p1.next;
                del--;
            }
        } else {
            while (del < 0) {
                p2 = p2.next;
                del++;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    public static ListNode gen(int[] r) {
        ListNode root = new ListNode(r[0]);
        ListNode p = root;
        for (int i = 1; i < r.length; i++) {
            p.next = new ListNode(r[i]);
            p = p.next;
        }
        return root;
    }

    public static void main(String[] args) {
        T160getIntersectionNode t = new T160getIntersectionNode();
        ListNode node1 = gen(new int[]{4, 1, 8, 4, 5});
        ListNode node2 = gen(new int[]{5, 0, 1});
        ListNode p1=node1,p2=node2;
        while(p2.next!=null){
            p2=p2.next;
        }
        while(p1.val!=8){
            p1=p1.next;
        }
        p2.next=p1;
        t.getIntersectionNode(node1,node2);

    }
}
