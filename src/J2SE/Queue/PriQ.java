package J2SE.Queue;

import java.util.PriorityQueue;

/**
 * Author:cafe3165
 * Date:2020-09-07
 */
public class PriQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.offer(5);
        pq.offer(3);
        pq.offer(0);
        pq.offer(19);
        pq.offer(4);
        while(pq.size()>0){
            System.out.println(pq.poll());
        }
    }
}
