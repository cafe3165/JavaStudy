package leetcode_daily;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Author:cafe3165
 * Date:2020-05-24
 */
public class T23mergeKLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (true) {
            ListNode minNode = null;
            int minPointer = -1;
            for (int i = 0; i < k; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minNode == null || lists[i].val < minNode.val) {
                    minPointer = i;
                    minNode = lists[i];
                }
            }
            if (minPointer == -1) {
                break;
            }
            tail.next = minNode;
            tail = tail.next;
            lists[minPointer] = lists[minPointer].next;
        }
        return dummy.next;
    }

    public static ListNode mergeKLists2(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.offer(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            tail.next = minNode;
            tail = tail.next;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummy.next;

    }

    public static void main(String[] args) {
        ListNode[] ln = gen();
        mergeKLists(ln);

    }

    public static ListNode[] gen() {
        ListNode[] ln = new ListNode[3];
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;

        ListNode m1 = new ListNode(1);
        ListNode m2 = new ListNode(3);
        ListNode m3 = new ListNode(4);
        m1.next = m2;
        m2.next = m3;

        ListNode q1 = new ListNode(2);
        ListNode q2 = new ListNode(6);
        q1.next = q2;

        ln[0] = n1;
        ln[1] = m1;
        ln[2] = q1;

        return ln;
    }

}
