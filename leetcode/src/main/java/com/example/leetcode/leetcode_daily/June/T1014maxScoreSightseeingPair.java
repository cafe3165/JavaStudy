package com.example.leetcode.leetcode_daily.June;

/**
 * Author:cafe3165
 * Date:2020-06-17
 */
public class T1014maxScoreSightseeingPair {
    public int maxScoreSightseeingPair(int[] A) {
        int max = A[0];
        int res = Integer.MIN_VALUE;
        for (int j = 1; j < A.length; j++) {
            res = Math.max(res, max + A[j] - j);
            max = Math.max(max, A[j] + j);
        }
        return res;
    }

    public static void main(String[] args) {
        T1014maxScoreSightseeingPair t = new T1014maxScoreSightseeingPair();
        int[] A = {8, 1, 5, 2, 6};
        t.maxScoreSightseeingPair(A);
    }
}
