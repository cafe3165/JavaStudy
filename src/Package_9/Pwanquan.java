package Package_9;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-08-09
 */
public class Pwanquan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), V = sc.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int[][] dp = new int[N + 1][V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                for (int k = 0; j >= k * w[i]; k++) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - k * w[i]] + k * v[i]);
                }
            }
        }
        System.out.println(dp[N][V]);


    }
}
