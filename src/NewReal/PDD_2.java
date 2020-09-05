package NewReal;


import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-01
 */
public class PDD_2 {
    public static int solve(int[][] grid) {
        int res = 0;
        int second=0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    int cur=dfs(i, j, grid);
                    if(cur>res){
                        second=res;
                        res=cur;
                    }
                }
            }
        }
        return res+second;

    }

    private static int dfs(int i, int j, int[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;

        int tmp = 1;
        tmp += dfs(i + 1, j, grid);
        tmp += dfs(i - 1, j, grid);
        tmp += dfs(i, j + 1, grid);
        tmp += dfs(i, j - 1, grid);
        return tmp;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(grid)+1);
    }
}
