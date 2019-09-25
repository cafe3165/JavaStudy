import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ReverseListSolution {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode ReverseList(ListNode head) {
        if(head==null)
            return null;

        ListNode p = null;
        ListNode q = null;
        while(head!=null){
            q=head.next;
            head.next=p;
            p=head;
            head=q;
        }

        return p;

    }

    public static void main(String[] args) {
        ListNode n1, n2, n3, n4, n5;
        n1 = new ListNode(1);
        n2 = new ListNode(2);
        n3 = new ListNode(3);
        n4 = new ListNode(4);
        n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ReverseList(n1);
    }

}
