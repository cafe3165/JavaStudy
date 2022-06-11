package com.example.leetcode.leetcode_list400;

import java.util.Map;

public class StoneGames {
    public static void main(String[] args) {
        int[] piles = {3, 9, 1, 2};
        System.out.println(solve(piles));
    }

    static class pair {
        public int fir;
        public int sec;

        public pair(int f, int s) {
            fir = f;
            sec = s;
        }
    }

    public static int solve(int[] piles) {
        int len = piles.length;
        pair[][] dp = new pair[len][len];

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {

                if(i==j){
                    dp[i][j] = new pair(piles[i], 0);
                }
                else{
                    dp[i][j] = new pair(0, 0);
                }
            }

        }

        for (int l = 1; l < len; l++) {
            for (int i = 0; i < len - l; i++) {
                int j = l + i ;
                // 先手选择最左边或最右边的分数
                int left = piles[i] + dp[i+1][j].sec;
                int right = piles[j] + dp[i][j-1].sec;
                // 套用状态转移方程
                if (left > right) {
                    dp[i][j].fir = left;
                    dp[i][j].sec = dp[i+1][j].fir;
                } else {
                    dp[i][j].fir = right;
                    dp[i][j].sec = dp[i][j-1].fir;
                }
            }
        }

        return dp[0][len - 1].fir - dp[0][len - 1].sec;

    }


}
