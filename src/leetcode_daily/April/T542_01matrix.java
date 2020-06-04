package leetcode_daily.April;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Author:cafe3165
 * Date:2020-04-15
 */
public class T542_01matrix {
    public static class pair {
        public int x;
        public int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[][]{};
        }
        int R = matrix.length, C = matrix[0].length;
        int[][] res = new int[R][C];
        boolean[][] vis = new boolean[R][C];
        Queue<pair> q = new LinkedList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 0) {
                    q.offer(new pair(i, j));
                    vis[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            pair p = q.poll();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int newx = x + dir[i][0];
                int newy = y + dir[i][1];
                if (newx < 0 || newx >= R || newy < 0 || newy >= C || vis[newx][newy]) {
                    continue;
                }
                res[newx][newy] = res[x][y] + 1;
                vis[newx][newy] = true;
                q.offer(new pair(newx, newy));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T542_01matrix t = new T542_01matrix();
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1},
        };
        t.updateMatrix(matrix);

    }
}
