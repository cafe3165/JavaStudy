package leetcode_daily.May;

import java.util.List;
import java.util.Stack;

/**
 * Author:cafe3165
 * Date:2020-05-16
 */
public class T25reverseKGroup {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dum = new ListNode(-1);
        dum.next = head;
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }
        int c = len / k;
        int K = k;
        p = head;
        ListNode pre = dum;
        while (c > 0) {
            k = K;
            while (k > 0) {
                stack.push(p);
                p = p.next;
                k--;
            }
            while(!stack.isEmpty()){
                ListNode n=stack.pop();
                n.next=pre;
                pre=n;
            }

        }
        return head;
    }

    public static ListNode rever(ListNode dum, int k) {
        ListNode pre = null;
        ListNode cur = dum.next;
        while (k > 0) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            k--;
        }
        return pre;
    }


    public static void main(String[] args) {
        ListNode root = gen();
        int k = 2;
        root = reverseKGroup(root, k);
        while (root != null) {
            System.out.print(root.val);
            root = root.next;
        }

    }

    public static ListNode gen() {
        ListNode root = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        root.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return root;


    }
}
