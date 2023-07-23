package com.example.m;

/**
 * Author:cafe3165
 * Date:2023-05-15
 */
public class D1 {

    static class ListNode {
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(0);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println(solve(head));
    }

    public static boolean solve(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int len = 0;
        ListNode p = head;
        while(p != null) {
            p = p.next;
            len ++;
        }
        ListNode head2 = null;
        int count = 0;
        p = head;
        while (count < len / 2) {
            p = p.next;
            count++;
        }
        if (len % 2 != 0) {
            p = p.next;
        }
        head2 = p;
        head = reverse(head, len);

        while (head != null) {
            if (head.val != head2.val) {
                return false;
            }
            head = head.next;
            head2 = head2.next;
        }

        return true;
    }

    private static ListNode reverse(ListNode head, int len) {
        int count = 0;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null && count < len / 2) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            count ++;
        }
        return pre;
    }


}
