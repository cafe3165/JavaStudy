package leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-06-06
 */
public class T64minPathSum {
    public static int minPathSum(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[][] dp = new int[R][C];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < R; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < C; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }

        return dp[R-1][C-1];
    }


    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        minPathSum(grid);

    }
}
