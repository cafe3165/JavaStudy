package newcoder;

public class MergeSolution {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        ListNode p = list1;
        ListNode q = list2;
        ListNode head = null;
        ListNode r = null;

        if (p == null)
            return q;
        if (q == null)
            return p;
        if (p == null && q == null)
            return null;

        if (p.val > q.val) {
            head = q;
            q = q.next;
        } else {
            head = p;
            p = p.next;
        }

        r = head;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                r.next = p;
                r = r.next;
                p = p.next;
                continue;
            } else {
                r.next = q;
                r = r.next;
                q = q.next;
            }
        }
        if (p != null)
            r.next = p;

        else
            r.next = q;

//        while (head != null) {
////            System.out.println(head.val);
////            head = head.next;
////        }


        return head;


    }

    public static void main(String[] args) {
        ListNode n1, n2, n3, n4, n5;
        n1 = new ListNode(1);
        n2 = new ListNode(2);
        n3 = new ListNode(6);
//        n4 = new ListNode(8);
//        n5 = new ListNode(9);
        n1.next = n2;
        n2.next = n3;
//        n3.next = n4;
////        n4.next = n5;
        ListNode n11, n22, n33, n44, n55;
        n11 = new ListNode(0);
        n22 = new ListNode(3);
        n33 = new ListNode(4);
        n44 = new ListNode(6);

        n11.next = n22;
        n22.next = n33;
        n33.next = n44;


        Merge(n1, n11);
    }
}
