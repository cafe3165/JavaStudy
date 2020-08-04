package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-08-02
 */
public class PDD_3 {
    //    3 3 10
//            1 1
//            2 5
//            3 7
//            2 4
//            4 8
//            6 9
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M, T;
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();
        int[] hot = new int[N + M];
        int[] dili = new int[N + M];
        for (int i = 0; i < N + M; i++) {
            hot[i] = sc.nextInt();
            dili[i] = sc.nextInt();
        }
        int[][] dp = new int[N + M + 1][T+1];
        for (int i = 0; i <= T; i++) {
//            dp[0][i]=
        }



    }
}
