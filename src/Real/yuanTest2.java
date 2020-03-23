package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-03-20
 */
public class yuanTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, m;
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        solution(a);
    }

    private static void solution(int[][] a) {
        int r = a.length, c = a[0].length;

        int[] res = new int[r * c];
        int[] _x = {1, 0, -1, 0};
        int[] _y = {0, 1, 0, -1};
        int x = 0, y = 0, di = 0;
        for (int i = 0; i < r * c; i++) {
            res[i] = a[x][y];
            a[x][y] = -1;
            int cr = x + _x[di];
            int cc = y + _y[di];

            if (cr < r && cr >= 0 && cc < c && cc >= 0 && a[cr][cc] != -1) {
                x = cr;
                y = cc;
            } else {
//                转向
                di = (di + 1) % 4;
                x += _x[di];
                y += _y[di];
            }


        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            sb.append(String.valueOf(res[i]));
            sb.append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
