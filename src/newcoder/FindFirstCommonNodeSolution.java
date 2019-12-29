package newcoder;

import java.util.List;

public class FindFirstCommonNodeSolution {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        //0-1-2-3-4   -5-null-7-8-4-5-null
//        7-8-4-5-null-0-1   -2-3-4
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) {
                    p1 = pHead2;
                }
                if (p2 == null) {
                    p2 = pHead1;
                }
            }
        }
        return p1;

    }

    //0-1-2-3-4-5-null
//    7-8-4-5-null
    public ListNode Gen1() {
        ListNode n0 = new ListNode(0);
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        return n0;

    }

    public ListNode Gen2() {
        ListNode n0 = new ListNode(7);
        ListNode n1 = new ListNode(8);

        n0.next = n1;

        return n0;
    }


    public static void main(String[] args) {
        FindFirstCommonNodeSolution f = new FindFirstCommonNodeSolution();
        ListNode n1 = f.Gen1();
        ListNode n2 = f.Gen2();
        n2.next=n1.next.next.next.next;
        f.FindFirstCommonNode(n1, n2);

    }
}