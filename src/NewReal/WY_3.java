package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-12
 */
public class WY_3 {

    public static boolean[] vis;
    public static int res = 0;

    public static int[][] createGraph(int[] vex, int vn) {
        int[][] graph = new int[vn][vn];
        vis = new boolean[vn];
        for (int i = 0; i < vex.length; i++) {
            graph[i + 1][vex[i]] = 1;
            graph[vex[i]][i + 1] = 1;
        }
        return graph;
    }

    public static void dfs(int[][] graph, int n, int i, int gas) {
        vis[i] = true;
        if (gas == 0) {
            res = Math.max(res, countVis());
            return;
        }

        for (int j = 0; j < n; j++) {
            if (graph[i][j] != 0 && !vis[j]) {
                dfs(graph, n, j, gas - 1);
            }
        }
    }

    public static int countVis() {
        int count = 0;
        for (int i = 0; i < vis.length; i++) {
            if (vis[i]) {
                count++;
            }
        }
        return count ;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s = sc.nextInt();
        int[] g = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            g[i] = sc.nextInt();
        }
        int[][] graph = createGraph(g, n);
        dfs(graph, n, 0, s);
        System.out.println(res);
    }
}
