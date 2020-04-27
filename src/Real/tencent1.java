package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-26
 */
public class tencent1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[][] A = new int[n][2], B = new int[n][2];
            for (int j = 0; j < n; j++) {
                A[j][0] = sc.nextInt();
                A[j][1] = sc.nextInt();
            }
            for (int j = 0; j < n; j++) {
                B[j][0] = sc.nextInt();
                B[j][1] = sc.nextInt();
            }
            double Min = Double.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    double tmp=(double)(A[j][0] - B[k][0]) * (A[j][0] - B[k][0]) + (A[j][1] - B[k][1]) * (A[j][1] - B[k][1]);
                    Min = Math.min(Min, Math.sqrt(tmp));
                }
            }
            System.out.println(String.format("%.3f",Min));


        }

    }
}
