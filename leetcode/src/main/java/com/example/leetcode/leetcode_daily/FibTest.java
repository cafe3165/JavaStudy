package com.example.leetcode.leetcode_daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-03-08
 */
public class FibTest {
    public static int fib(int N) {
        int[] m = new int[N + 1];

        return help(m, N);


//        int[] dp = new int[N + 1];;
//        // base case
//        dp[1] = dp[2] = 1;
//        for (int i = 3; i <= N; i++)
//            dp[i] = dp[i - 1] + dp[i - 2];
//        return dp[N];


    }

    public static int help(int[] m, int n) {
        if (n == 1 | n == 2) {
            return 1;
        }
        if (m[n] != 0) {
            return m[n];
        }
        m[n] = help(m, n - 1) + help(m, n - 2);
        return m[n];

    }


    public static void main(String[] args) {
        System.out.println(fib(4));
    }
}
