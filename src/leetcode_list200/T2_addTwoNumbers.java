package leetcode_list200;

import java.util.ArrayList;

public class T2_addTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        int carry = 0;
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode curr = dummyHead;

        while (p1 != null || p2 != null) {
            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p1 != null) {
                p1 = p1.next;
            }
            if (p2 != null) {
                p2 = p2.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

    return dummyHead.next;
    }

    public ArrayList<ListNode> Gen() {
        ArrayList<ListNode> lList = new ArrayList<>();
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(2);

        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(5);
        l4.next = l5;
        l5.next = l6;
        lList.add(l1);
        lList.add(l4);
        return lList;
    }

    public static void main(String[] args) {
        T2_addTwoNumbers t = new T2_addTwoNumbers();
        ArrayList<ListNode> list = t.Gen();
        ListNode l1 = list.get(0);
        ListNode l2 = list.get(1);
        t.addTwoNumbers(l1, l2);

    }
}
