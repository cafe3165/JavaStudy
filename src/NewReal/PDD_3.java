package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-01
 */
public class PDD_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), V = sc.nextInt();
        int[] v = new int[N + 1];
        int[] w = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            w[i] = sc.nextInt();
            v[i] = sc.nextInt();
        }
        int[][] dp = new int[N+1][V + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= V; j++) {
                if (j < w[i]) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }
            }
        }
        System.out.println(dp[N][V]);
    }
}
