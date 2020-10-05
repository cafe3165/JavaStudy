package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-17
 */
public class JD_2 {
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt(), m = sc.nextInt();
            char[][] map = new char[n][m];
            for (int j = 0; j < n; j++) {
                char[] row = sc.next().toCharArray();
                map[i] = row;
            }
            int Sx = 0, Sy = 0, Ex = 0, Ey = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (map[j][k] == 'S') {
                        Sx = j;
                        Sy = k;
                    }
                    if (map[j][k] == 'E') {
                        Ex = j;
                        Ey = k;
                    }
                }
            }
            boolean[][] visited = new boolean[map.length][map[0].length];
            if (dfs(map, Sx, Sy, Ex, Ey, map.length, map[0].length, visited)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }


    public static boolean dfs(char[][] map, int x, int y, int a, int b, int R, int C, boolean[][] visited) {
        if (x == a && y == b) {
            return true;
        }
        visited[x][y] = true;

        for (int[] d : dir) {
            int newx = x + d[0];
            int newy = y + d[1];
            if (newx >= 0 && newx < R && newy >= 0 && newy < C && map[newx][newy] != '#' && !visited[newx][newy]) {
                dfs(map, newx, newy, a, b, R, C, visited);
            }
        }
        return false;
    }
}
