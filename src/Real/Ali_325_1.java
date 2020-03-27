package Real;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-03-25
 */
public class Ali_325_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = Integer.MAX_VALUE;
        int[][] a = new int[3][n];
        int[][] dp = new int[3][2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < 3; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            dp[i][0] = 0;
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < 3; i++) {
                dp[i][j % 2] = Math.min(dp[i][j % 2], Math.abs(a[i][j] - a[0][j - 1]) + dp[0][(j + 1) % 2]);
                dp[i][j % 2] = Math.min(dp[i][j % 2], Math.abs(a[i][j] - a[1][j - 1]) + dp[1][(j + 1) % 2]);
                dp[i][j % 2] = Math.min(dp[i][j % 2], Math.abs(a[i][j] - a[2][j - 1]) + dp[2][(j + 1) % 2]);
            }
            dp[0][(j+1)%2]=Integer.MAX_VALUE;
            dp[1][(j+1)%2]=Integer.MAX_VALUE;
            dp[2][(j+1)%2]=Integer.MAX_VALUE;
        }
        for (int i = 0; i < 3; i++) {
            res=Math.min(res,dp[i][(n+1)%2]);
        }
        System.out.println(res);


    }
}
