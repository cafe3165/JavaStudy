package leetcode_daily.March;

/**
 * Author:cafe3165
 * Date:2020-03-08
 */
public class T206ReverseList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(0);
        pre.next = head;
//        1->2->3->4->5->NULL
        while (head.next != null) {
            ListNode p = head.next;
            pre.next = p;
            ListNode q = p.next;
            p.next = head;
            head.next = q;
        }

        return pre.next;
    }

    public ListNode con(){
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        return n1;
    }

    public static void main(String[] args) {
        T206ReverseList t=new T206ReverseList();
        ListNode node=t.con();
        t.reverseList(node);

    }

}
