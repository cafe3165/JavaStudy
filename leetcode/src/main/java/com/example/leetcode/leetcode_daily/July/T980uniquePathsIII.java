package com.example.leetcode.leetcode_daily.July;

import java.util.ArrayList;
import java.util.List;

public class T980uniquePathsIII {
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private List<List<pair>> res = new ArrayList<>();
    boolean[][] vis;

    private int endx, endy;

    class pair {
        int x;
        int y;

        public pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private int step = 0;

    public int uniquePathsIII(int[][] grid) {
        int stax = 0, stay = 0;
        int m = grid.length, n = grid[0].length;
        vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    step++;
                }
                if (grid[i][j] == 1) {
                    stax = i;
                    stay = j;
                }
                if (grid[i][j] == 2) {
                    endx = i;
                    endy = j;
                }

            }
        }
        dfs(grid, stax, stay, new ArrayList<>());
        return res.size();
    }

    private void dfs(int[][] grid, int x, int y, List<pair> Path) {
//        if (vis[x][y] || x >= grid.length || x <= 0 || y >= grid[0].length || y <= 0) {
//            return;
//        }
        if (grid[x][y] == 2) {
            if (Path.size() - 1== step) {
                res.add(new ArrayList<>(Path));
            }
            return;
        }
        vis[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + dir[i][0];
            int newY = y + dir[i][1];
            if ((0 <= newX && newX < grid.length) && (0 <= newY && newY < grid[0].length) && !vis[newX][newY] && grid[newX][newY] != -1) {
                pair tmp = new pair(newX, newY);
                Path.add(tmp);
                dfs(grid, newX, newY, Path);
                Path.remove(tmp);
            }
        }
        vis[x][y] = false;
    }


    /*1 表示起始方格。且只有一个起始方格。
      2 表示结束方格，且只有一个结束方格。
      0 表示我们可以走过的空方格。
     -1 表示我们无法跨越的障碍。*/
    public static void main(String[] args) {
        T980uniquePathsIII t = new T980uniquePathsIII();
        int[][] gird = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        t.uniquePathsIII(gird);
    }
}
