package com.example.leetcode.leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-05-31
 */
public class T1277countSquares {
    public static int countSquares(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length, len = Math.min(m, n);
        boolean[][][] dp = new boolean[m][n][len];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = (matrix[i][j] == 1);
                count += dp[i][j][0] ? 1 : 0;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                for (int k = 1; k < len; k++) {
                    dp[i][j][k] = (matrix[i][j] == 1 && dp[i - 1][j][k - 1] && dp[i][j - 1][k - 1] && dp[i - 1][j - 1][k - 1]);
                    if (dp[i][j][k]) {
                        count++;
                    }

                }
            }
        }
        return count;
    }

    public static int countSquares2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0];
            ans += dp[i][0];
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
            ans += dp[0][i];
        }
        if (matrix[0][0] == 1) {
            ans--;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    ans += dp[i][j];
                }

            }
        }

    return ans;
    }

    public static void main(String[] args) {
        int[][] matrix =
                {
                        {0, 1, 1, 1},
                        {1, 1, 1, 1},
                        {0, 1, 1, 1}
                };
        countSquares2(matrix);
    }
}
