package leetcode_daily.May;

/**
 * Author:cafe3165
 * Date:2020-05-31
 */
public class T221maximalSquare {
    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return 0;
        }
        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length; i++) {
                if (matrix[0][i] == '1') {
                    return 1;
                }
            }
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            dp[i][0] = matrix[i][0] - '0';
            max = Math.max(dp[i][0], max);
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] - '0';
            max = Math.max(dp[0][i], max);

        }


        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(dp[i][j], max);
                }

            }
        }
        return max * max;
    }

    public static void main(String[] args) {
//        char[][] matrix =
//                {
//                        {'1', '0', '1', '0', '0'},
//                        {'1', '0', '1', '1', '1'},
//                        {'1', '1', '1', '1', '1'},
//                        {'1', '0', '0', '1', '0'}
//                };
        char[][] matrix = {{'0', '1'}, {'1', '0'}};
        maximalSquare(matrix);

    }
}
