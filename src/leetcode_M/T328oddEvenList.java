package leetcode_M;

/**
 * Author:cafe3165
 * Date:2020-04-15
 */
public class T328oddEvenList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode gen() {
        ListNode root = new ListNode(1);
        ListNode p = root;
        int[] r = {1};
        for (int i = 0; i < r.length; i++) {
            p.next = new ListNode(r[i]);
            p = p.next;
        }
        return root;
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode oddhead = new ListNode(-1), evenhead = new ListNode(-2);
        ListNode odd = head, even = head.next;
        oddhead.next = odd;
        evenhead.next = even;
        ListNode joint = odd;
        while (even != null && odd != null) {

            odd.next = even.next;
            odd = odd.next;
            if (odd != null) {
                joint = odd;
                even.next = odd.next;
                even = even.next;
            } else {
                even.next = null;

            }
        }

        joint.next = evenhead.next;


        return oddhead.next;

    }

    public static void main(String[] args) {
        T328oddEvenList t = new T328oddEvenList();
        t.oddEvenList(gen());

    }
}
