package leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-03-29
 */
public class T200numIslands {

    public static boolean[][] visited;
    public static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public static int rows;
    public static int cols;
    public static char[][] Grid;

    public int numIslands(char[][] grid) {
        if(grid.length==0){
            return 0;
        }
        rows = grid.length;
        cols = grid[0].length;
        Grid = grid;
        visited = new boolean[rows][cols];
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(i, j);
                    res++;
                }
            }
        }


        return res;
    }

    private void dfs(int i, int j) {
        visited[i][j] = true;
        for (int[] d : dir) {
            int X = i + d[0];
            int Y = j + d[1];
            if (X >= 0 && X < rows && Y >= 0 && Y < cols && Grid[X][Y] == '1' && !visited[X][Y]) {
                dfs(X, Y);
            }
        }


    }


    public static void main(String[] args) {
        char[][] grid = {{'1', '1', '0', '0', '0'}
                , {'1', '1', '0', '0', '0'}
                , {'0', '0', '1', '0', '0'}
                , {'0', '0', '0', '1', '1'}
        };
        T200numIslands t = new T200numIslands();
        t.numIslands(grid);


    }


}
