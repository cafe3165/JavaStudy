package com.example.leetcode.leetcode_list400;

/**
 * Author:cafe3165
 * Date:2020-09-19
 */
public class T518 {
    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(change(5, coins));
    }
}
