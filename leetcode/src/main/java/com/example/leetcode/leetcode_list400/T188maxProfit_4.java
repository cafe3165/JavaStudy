package com.example.leetcode.leetcode_list400;

public class T188maxProfit_4 {
    public int maxProfit(int k, int[] prices) {

        int n = prices.length;
        if (k > n / 2)
            return maxProfit_inf(prices);

        int[][][]dp=new int[n][k+1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >=1; j--) {
                if(i==0){
                    dp[i][j][0]=0;
                    dp[i][j][1]=-prices[i];
                }else{
                    dp[i][j][0]=Math.max(dp[i-1][j][0],dp[i-1][j][1]+prices[i]);
                    dp[i][j][1]=Math.max(dp[i-1][j][1],dp[i-1][j-1][0]-prices[i]);
                }
            }
        }
        return dp[n-1][k][0];

    }

    private int maxProfit_inf(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
            } else {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        T188maxProfit_4 t = new T188maxProfit_4();
        int[] prices = {3, 2, 6, 5, 0, 3};
        int k = 2;
        t.maxProfit(k, prices);
    }
}
