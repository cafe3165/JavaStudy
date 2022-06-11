package com.example.leetcode.leetcode_list400;

public class T123maxProfit_2 {
    public int maxProfit(int[] prices) {
        int max_k = 2;
        int n = prices.length;
        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int k = max_k; k >= 1; k--) {
                if (i  == 0) {
                    /*处理 base case */
                    dp[i][k][0]=0;
                    dp[i][k][1]=-prices[i];

                }else {
                    dp[i][k][0] = Math.max(dp[i - 1][k][0], dp[i - 1][k][1] + prices[i]);
                    dp[i][k][1] = Math.max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - prices[i]);
                }
            }
        }
        // 穷举了 n × max_k × 2 个状态，正确。
        return dp[n - 1][max_k][0];


    }

    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        T123maxProfit_2 t = new T123maxProfit_2();
        t.maxProfit(prices);
    }
}
