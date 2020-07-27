package beibao_9;

import java.util.Scanner;

public class beibao_01 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), V = sc.nextInt();
        int[][] things = new int[N][2];
        for (int i = 0; i < N; i++) {
            things[i][0] = sc.nextInt();
            things[i][1] = sc.nextInt();
        }
//        int[][] dp = new int[N+1 ][V + 1];
//        for (int i = 1; i <= N; i++) {
//            for (int j = 0; j <= V; j++) {
//                //最重要的一行
//                dp[i][j]=dp[i-1][j];
//                if (j >= things[i - 1][0]) {
//                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - things[i - 1][0]] + things[i - 1][1]);
//                }
//            }
//        }
        int[] dp=new int[ V + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = V; j >= things[i - 1][0]; j--) {
                dp[j]=Math.max(dp[j],dp[j-things[i-1][0]]+things[i-1][1]);

            }
        }

//        System.out.println(dp[N][V]);
        System.out.println(dp[V]);

    }
}
