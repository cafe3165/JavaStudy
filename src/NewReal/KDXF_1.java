package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-12
 */
public class KDXF_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < m; l++) {
                        if (i != k && j != l) {
                            res = Math.max(res, matrix[i][j] * matrix[k][l]);
                        }
                    }
                }
            }
        }
        System.out.println(res);
    }
}
