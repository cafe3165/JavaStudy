package com.example.leetcode.leetcode_daily.March;

import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * Author:cafe3165
 * Date:2020-03-20
 */
public class M40getLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0){
            return new int[]{};
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((x1, x2) -> x2 - x1);

        for (int i = 0; i < arr.length; i++) {
            if (pq.size() < k) {
                pq.offer(arr[i]);
            } else if (arr[i] < pq.peek()) {
                pq.poll();
                pq.offer(arr[i]);
            }

        }

        int[] res = new int[k];
        int index = 0;
        Iterator<Integer> it = pq.iterator();
        while (it.hasNext()) {
            res[index++] = it.next();
        }
        return res;


    }


    public static void main(String[] args) {
        M40getLeastNumbers m = new M40getLeastNumbers();
        int[] arr = {0, 0, 0, 2, 0, 5};
        int k = 0;
        m.getLeastNumbers(arr, k);

    }
}
