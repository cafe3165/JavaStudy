package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-01
 */
public class PDD_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        solve(matrix, n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != n - 1) {
                    System.out.print(matrix[i][j] + " ");
                } else {
                    System.out.println(matrix[i][j]);
                }
            }
        }


    }

    private static void solve(int[][] matrix, int n) {
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            for (int j = mid; j < n - 1; j++) {
                matrix[i][j] = 1;
            }
            for (int j = n - i; j < n; j++) {
                matrix[i][j] = 8;
            }
            for (int j = i + 1; j < mid; j++) {
                matrix[i][j] = 2;
            }
            for (int j = 0; j < i; j++) {
                matrix[i][j] = 3;
            }

        }
        for (int i = mid; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                matrix[i][j] = 4;
            }
            for (int j = n - i; j < mid; j++) {
                matrix[i][j] = 5;
            }
            for (int j = mid; j < i; j++) {
                matrix[i][j] = 6;
            }
            for (int j = i + 1; j < n; j++) {
                matrix[i][j] = 7;
            }
        }
        for (int i = 0; i < n; i++) {
            matrix[i][i] = 0;
            matrix[i][matrix.length - i - 1] = 0;
        }
        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) {
                matrix[mid][i] = 0;
                matrix[i][mid] = 0;
            }
        }
    }
}
