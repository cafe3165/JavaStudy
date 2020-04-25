package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-20
 */
public class duxiaoman2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a = sc.nextInt(), b = sc.nextInt();
        int[][] arr = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                arr[i][j] = (i * j) % 10;
            }
        }
        solve(n, m, a, b, arr);

    }

    private static void solve(int n, int m, int a, int b, int[][] arr) {
        int res = 0;


        for (int col = 1; col <= m - b + 1; col++) {
            for (int i = 1; i <= n + 1 - a; i++) {
                int tmpres = 0;
                for (int j = i; j <= i + a - 1 && j <= i + a - 1; j++) {
                    for (int k = col; k <= col + b - 1; k++) {
                        tmpres = Math.max(arr[j][k], tmpres);
                    }
                }
                res += tmpres;
            }
        }


        System.out.println(res);
    }
}

