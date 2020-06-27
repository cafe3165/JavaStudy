package leetcode_daily.June;

import J2SE.HashMapTest;

import java.util.HashSet;
import java.util.Set;

public class M0201removeDuplicateNodes {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        Set<Integer> set=new HashSet<>();
        dummy.next = head;
        ListNode pre=dummy;
        ListNode cur=head;
        while(cur!=null){
            if(!set.contains(cur.val)){
                pre.next=cur;
                pre=pre.next;
                set.add(cur.val);
            }else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }



        return dummy.next;

    }

    private ListNode gen() {
        int[] a = {1, 2, 3, 3, 2, 1};
        ListNode root = new ListNode(a[0]);
        ListNode head=root;
        for (int i = 1; i < a.length; i++) {
            ListNode next = new ListNode(a[i]);
            root.next = next;
            root = root.next;
        }
        return head;
    }

    public static void main(String[] args) {
        M0201removeDuplicateNodes m = new M0201removeDuplicateNodes();
        m.removeDuplicateNodes(m.gen());

    }
}
