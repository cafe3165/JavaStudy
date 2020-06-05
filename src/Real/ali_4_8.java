package Real;


import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-08
 */
public class ali_4_8 {
    public static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static int R;
    public static int C;
    public static int K;
    public static boolean[][] visited;
    public static int[][] A;
    public static int ME = Integer.MIN_VALUE;

    public static class solu {
        public int dis;
        public int enr;

        public solu(int dis, int enr) {
            this.dis = dis;
            this.enr = enr;
        }
    }


    public int movingCount(int n, int k) {
        R = n;
        C = n;
        K = k;
        visited = new boolean[n][n];
        solu s = dfs(0, 0, 0, A[0][0],k);
        System.out.println(ME);
        return s.enr;

    }

    public static solu dfs(int x, int y, int dis, int energy,int k) {
        if (x < 0 || x > R - 1 || y < 0 || y > C - 1 || dis > K || visited[x][y]) {
            return new solu(0, energy-A[x][y]);
        }
        visited[x][y] = true;
        int max = 0;

        for (int[] d : dir) {
            int newx = x + d[0];
            int newy = y + d[1];
            if (newx >= 0&& newx <= R - 1 && newy >= 0 && newy <= C - 1&& A[newx][newy] > A[x][y]&&!visited[newx][newy]) {
                solu tmp = dfs(newx, newy, max+1, energy + A[newx][newy],k-1);
                max = tmp.dis;
                energy = tmp.enr;

            } else {
                continue;
            }
        }
        ME=Math.max(energy,ME);
        solu res = new solu(max, energy-A[x][y]);
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        ali_4_8 M = new ali_4_8();
        A = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }
//        3 1 1 2 5 10 11 6 12 12 7

        System.out.println(M.movingCount(n, k));
    }

}
