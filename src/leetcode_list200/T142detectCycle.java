package leetcode_list200;

import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-05-26
 */
public class T142detectCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);

        slow = head;
//        do {
//            fast = fast.next;
//            slow = slow.next;
//        } while (slow != fast);
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;


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
        detectCycle(gen());
    }
}
