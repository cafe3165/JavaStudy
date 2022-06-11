package com.example.leetcode.labuladong.HighFrequnt;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T875minEatingSpeed {
    public int minEatingSpeed(int[] piles, int H) {

        int len = piles.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, piles[i]);
        }
        int left = 1, right = max + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canEat(mid, piles, H)) {
                left = mid+1;
            } else {
                 right= mid;
            }
        }

        return left;
    }

    private boolean canEat(int speed, int[] piles, int H) {
        int count = 0;
        for (int pile : piles) {
            count += Math.ceil(pile * 1.0 / speed);
        }
        return count > H;
    }

    public static void main(String[] args) {
        T875minEatingSpeed t = new T875minEatingSpeed();
        int[] piles = {3, 6, 7, 11};
        int H = 8;
       // t.minEatingSpeed(piles, H);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        pq.offer(8);
        pq.offer(5);
        pq.offer(9);
        System.out.println(pq.poll());
        System.out.println(pq.peek());
        pq.remove(5);
    }
}
