package leetcode;

import newcoder.ReverseListSolution;

public class T19_removeNthFromEnd {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead= new ListNode(0);
        dummyHead.next=head;
        ListNode p=dummyHead,q=dummyHead;
        while(n>0){
            q=q.next;
            n--;
        }
        while(q.next!=null){
            q=q.next;
            p=p.next;
        }
        p.next=p.next.next;
        return dummyHead.next;


    }

    public ListNode gen(){
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

        return n1;
    }

    //    双指针
    public static void main(String[] args) {
        T19_removeNthFromEnd t=new T19_removeNthFromEnd();
        ListNode node=t.gen();
        int n=2;
        t.removeNthFromEnd(node,n);

    }
}
