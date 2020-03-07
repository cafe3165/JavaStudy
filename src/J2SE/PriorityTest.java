package J2SE;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Author:cafe3165
 * Date:2020-03-07
 */
public class PriorityTest {
    class ListNode {
        int data1;
        int data2;
        ListNode next;

        ListNode(int data1,int data2) {
            this.data1 = data1;
            this.data2 = data2;
        }
    }

    public ListNode con() {
        ListNode l1 = new ListNode(1,4);
        ListNode l2 = new ListNode(2,2);
        ListNode l3 = new ListNode(3,8);
        ListNode l4 = new ListNode(4,1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        return l1;


    }

    public static void main(String[] args) {
        PriorityTest p = new PriorityTest();
        ListNode root=p.con();
        ListNode q=root;
        PriorityQueue pq=new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o2.data1-o1.data1;
            }
        });
        while(q!=null){
            pq.offer(q);
            q=q.next;
        }
        Iterator it=pq.iterator();
        while(it.hasNext()){
            ListNode tmp=(ListNode)it.next();
            System.out.println(tmp.data1);
        }
//        System.out.println(pq.peek());
//        pq.poll();
//        System.out.println(pq.peek());

    }


}
