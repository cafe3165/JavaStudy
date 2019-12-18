package newcoder;

import java.util.ArrayList;
import java.util.List;

public class deleteDuplicationSolution {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2 != null) {
            if (p2.next != null && p2.next.val == p2.val) {
                while (p2.next != null && p2.next.val == p2.val) {
                    p2 = p2.next;
                }
                p2 = p2.next;
                p1.next=p2;


            }else{
                p1= p2;
                p2=p2.next;
            }

        }


        return head.next;
    }

    public static void main(String[] args) {
        deleteDuplicationSolution d = new deleteDuplicationSolution();

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);
        ListNode n7 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode p = d.deleteDuplication(n1);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }

    }
}
