package newcoder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class EntryNodeOfLoopSolution {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    List<ListNode> nodeList = new ArrayList<ListNode>();

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null || pHead.next.next == null) {
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        while (slow != fast) {
            if (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            } else {
                return null;
            }
        }

        fast=pHead;
        while(fast !=slow){
            fast = fast.next;
            slow=slow.next;
        }


        return slow;
    }

    public static void main(String[] args) {
        EntryNodeOfLoopSolution e = new EntryNodeOfLoopSolution();

        for (int i = 0; i < 6; i++) {
            ListNode l = new ListNode(i);
            e.nodeList.add(l);
        }
        for (int i = 0; i < 5; i++) {
            e.nodeList.get(i).next = e.nodeList.get(i + 1);
        }
        e.nodeList.get(5).next=e.nodeList.get(3);


        System.out.println(e.EntryNodeOfLoop(e.nodeList.get(0)).val);


    }
}
