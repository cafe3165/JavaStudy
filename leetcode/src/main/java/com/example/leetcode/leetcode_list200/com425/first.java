package com.example.leetcode.leetcode_list200.com425;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Author:cafe3165
 * Date:2020-04-25
 */
public class first {
    public static int minTime(int[] time, int m) {
        int day = 0;
        if (m >= time.length) {
            return 0;
        }
//        int index[] = new int[m];
        PriorityQueue<Integer> indexq = new PriorityQueue<>();
        indexq.add(0);
        int index=1;
        while (index<time.length) {
            if(time[index]>=time[indexq.peek()]&&indexq.size()==m){
                indexq.poll();
                indexq.offer(index);
                index++;
                continue;
            }
            indexq.offer(index);
            index++;
        }
        return day;

    }

    public static void main(String[] args) {
        int m = 2;
        int[] time = {1, 2, 3, 3};
        minTime(time, m);

    }
}
