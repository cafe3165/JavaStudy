package com.example.leetcode.labuladong.HighFrequnt;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse", s2 = "ros";
        solve(s1, s2);

    }

    public static int solve(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int min = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]);
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = min;
                } else {
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[m][n];

    }
}
