package labuladong.DataStruct;

import leetcode_daily.March.T206ReverseList;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * Author:cafe3165
 * Date:2020-09-13
 */
public class ReverseList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverse(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    static ListNode successor = null;

    public static ListNode reversen(ListNode head, int n) {
        if (n == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = reversen(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    public static ListNode reversnm(ListNode head, int m, int n) {
        if (m == 1) {
            return reversen(head, n);
        }
        head.next = reversnm(head.next, m - 1, n - 1);
        return head;
    }


    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        root.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
//        ListNode newhead=reversnm(root,2,4);
        ListNode newhead = reversen(root, 2);
        System.out.println(newhead);
        CountDownLatch cl = new CountDownLatch(10);
        CyclicBarrier cb=new CyclicBarrier(10);
        
    }
}
