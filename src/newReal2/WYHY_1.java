package newReal2;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-27
 */
public class WYHY_1 {
    private static int[][] dx = new int[][]{{0, 1, 0, -1}, {1, 0, -1, 0}};
    private static int[][] dy = new int[][]{{1, 0, -1, 0}, {0, 1, 0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt(), M = sc.nextInt();
            int[][] grid = new int[N][N];
            int count = 1, times = 0;
            for (int i = 0; i < (N + 1) / 2; i++) {
                int k = 0;
                int x = i, y = i;
                while (true) {
                    grid[x][y] = count++;
                    int x1 = x + dx[times % 2][k];
                    int y1 = y + dy[times % 2][k];
                    while (x1 < 0 || y1 < 0 || x1 >= N || y1 >= N || grid[x1][y1] != 0) {
                        k++;
                        if (k >= 4) {
                            break;
                        }
                        x1 = x + dx[times % 2][k];
                        y1 = y + dy[times % 2][k];
                    }
                    if (k >= 4) {
                        break;
                    }
                    x = x1;
                    y = y1;
                }
                times++;
            }
            for (int i = 0; i < M; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                System.out.println(grid[x][y]);
            }
        }

    }
}
