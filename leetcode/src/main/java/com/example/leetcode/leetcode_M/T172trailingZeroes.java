package com.example.leetcode.leetcode_M;

/**
 * Author:cafe3165
 * Date:2020-11-01
 */
public class T172trailingZeroes {
    public static int trailingZeroes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int N = i;
            while (N > 0) {
                if (N % 5 == 0) {
                    count++;
                    N /= 5;
                } else {
                    break;
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        int n = 11;
        trailingZeroes(n);
    }
}
