package newcoder;

public class FindKthToTailSoulution {

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode FindKthToTail(ListNode head, int k) {
        if (k==0)
            return null;

        ListNode p=head;
        ListNode q=null;
        int countCur=1,countAll=1;

        while(p!=null){
            if(countCur==k)
                q=head;
            if(countCur>k){
                q=q.next;
            }

            p=p.next;

            countCur++;
//            countAll++;
        }
//        System.out.println(q.val);

        return q;

    }

    public static void main(String[] args) {
        ListNode n1, n2, n3, n4, n5;
        n1 = new ListNode(1);
        n2 = new ListNode(2);
        n3 = new ListNode(3);
        n4 = new ListNode(4);
        n5 = new ListNode(5);
        int k = 0;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        FindKthToTail(n1, k);
    }
}
