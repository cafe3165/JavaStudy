package other;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Author:cafe3165
 * Date:2020-03-31
 */
public class pqtest {
    public static class stu {
        int score;
        String name;

        public  stu(int score, String name) {
            this.score = score;
            this.name = name;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        PriorityQueue<stu> spq = new PriorityQueue<>(new Comparator<stu>() {
            @Override
            public int compare(stu o1, stu o2) {
//                return  o2.score - o1.score;
                return o2.name.compareTo(o1.name);
            }
        });
        spq.offer(new pqtest.stu(20,"xiaoming"));
        spq.offer(new pqtest.stu(30,"xiaohua"));
        spq.offer(new pqtest.stu(10,"xiaomhong"));



        pq.offer(4);
        pq.offer(3);
        pq.offer(6);

        while (spq.size() != 0) {
            System.out.println(spq.poll().name);

        }

    }
}
