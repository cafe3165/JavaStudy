package com.example.leetcode.leetcode_daily.March;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Author:cafe3165
 * Date:2020-03-09
 */
public class T121maxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxP = 0, minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            maxP = Math.max(maxP, prices[i] - minPrice);
        }
        return maxP;


    }


    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            }
        }
        return dp[n - 1][0];
    }


    public static void main(String[] args) {
        T121maxProfit t = new T121maxProfit();
        Integer[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {3, 3};
//        t.maxProfit2(prices);
        Arrays.sort(prices,new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });

    }
}
