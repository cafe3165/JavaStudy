package leetcode_daily;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-03-29
 */
public class M13movingCount {
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int R;
    public static int C;
    public static int K;
    public static boolean[][] visited;


    public int movingCount(int m, int n, int k) {
        R = m;
        C = n;
        K = k;
        visited = new boolean[m][n];
        return dfs(0, 0);


    }

    public static int dfs(int x, int y) {
        if (x < 0 || x > R - 1 || y < 0 || y > C - 1 || cal(x, y) > K || visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        int max = 0;
        for (int[] d : dir) {
            int newx = x + d[0];
            int newy = y + d[1];
            max += dfs(newx, newy);
        }
        return max + 1;
    }

    public static int cal(int x, int y) {
        int res = 0;
        while (x != 0) {
            res += x % 10;
            x /= 10;
        }
        while (y != 0) {
            res += y % 10;
            y /= 10;
        }

        return res;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt(), k = sc.nextInt();
        M13movingCount M = new M13movingCount();
        M.movingCount(m, n, k);
    }

}
