package leetcode;

import java.util.List;

public class T23_swapPairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        ListNode q;
        if (head == null) {
            return null;
        }
        if (head.next != null) {
            q = head.next;
        } else {
            return dummyHead.next;
        }
        while (q != null) {
            p.next.next = q.next;
            q.next = p.next;
            p.next = q;
            if (q.next != null) {
                p = q.next;
            }
            if (p.next != null) {
                ListNode r = p.next;
                if (r.next != null) {
                    q = r.next;
                } else {
                    return dummyHead.next;
                }
            } else {
                return dummyHead.next;
            }
        }

        return dummyHead.next;
    }

    public ListNode swapPairs2(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode p = dummyHead;
        while (p.next != null && p.next.next != null) {
            ListNode start = p.next;
            ListNode end = p.next.next;
            start.next = end.next;
            p.next = end;
            end.next = start;
            p = start;
        }


        return dummyHead;

    }

    public ListNode gen() {
        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(3);
//        ListNode n4 = new ListNode(4);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
        return n1;
    }

    public static void main(String[] args) {

        T23_swapPairs t = new T23_swapPairs();
        ListNode head = null;
        t.swapPairs(head);

    }
}
