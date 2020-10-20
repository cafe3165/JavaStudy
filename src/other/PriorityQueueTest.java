package other;

import java.util.PriorityQueue;

public class PriorityQueueTest {
    public static void main(String[] args) {
//        PriorityQueue<Integer> pq = new PriorityQueue<>(10);
//        for (int i = 0; i < 100; i++) {
//            if (pq.size() < 10) {
//                pq.offer(i);
//            } else {
//                if (pq.peek() < i){
//                    pq.poll();
//                    pq.offer(i);
//                }
//            }
//
//        }
//        System.out.println(pq);
        int a = -4;
//        int b = -5;
//        System.out.println(a >> 2 > b >> 2);
        int w = 1 << 31;
        int v = 31;
        System.out.println(w);
        for (int i = 0; i < 32; i++) {
            int f = (a & w) >> v;
            System.out.println(f);
        }
    }
}
