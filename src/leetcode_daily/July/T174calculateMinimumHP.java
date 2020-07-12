package leetcode_daily.July;

public class T174calculateMinimumHP {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;

        for (int i = m - 2; i >= 0; i--) {
            dp[i][n - 1] = Math.max(dp[i + 1][n - 1] - dungeon[i + 1][n - 1], 1);
        }
        for (int i = n - 2; i >= 0; i--) {
            dp[m - 1][i] = Math.max(dp[m - 1][i + 1] - dungeon[m - 1][i + 1], 1);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int right = Math.max(dp[i][j + 1] - dungeon[i][j + 1], 1);
                int down = Math.max(dp[i + 1][j] - dungeon[i + 1][j], 1);
                dp[i][j]=Math.min(right,down);
            }
        }

        return Math.max(dp[0][0]-dungeon[0][0],1);
    }

    public static void main(String[] args) {
        T174calculateMinimumHP t = new T174calculateMinimumHP();
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 0, -5}
        };
        t.calculateMinimumHP(dungeon);

    }
}
