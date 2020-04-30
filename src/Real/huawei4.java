package Real;


import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-29
 */
public class huawei4 {
    public static int solve(int v, int[][] edges, int k, int[][] cost) {
        int vexnum = edges.length;
        boolean st[] = new boolean[vexnum];
        int[] dis = new int[vexnum];
        int[] cos = new int[vexnum];
        int allcost=0;

        for (int i = 0; i < vexnum; i++) {
            dis[i] = edges[v][i];
            cos[i] = cost[v][i];
        }
        st[v] = true;
        for (int i = 0; i < vexnum; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int j = 0; j < vexnum; j++) {
                if (st[j] == false) {
                    if (dis[j] < min) {
                        min = dis[j];
                        index = j;
                    }
                }
            }
            if (index != -1) {
                st[index] = true;

            }
            for (int j = 0; j < vexnum; j++) {
                if (!st[j] && index != -1 && edges[index][j] != Integer.MAX_VALUE && (min + edges[index][j]) < dis[j]) {
                    dis[j] = min + edges[index][j];
                    allcost+=cost[index][j];


                }
            }

        }
//        if(allcost>k|| dis[dis.length-1]==Integer.MAX_VALUE){
//            return -1;
//        }
        return dis[dis.length-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt(), N = sc.nextInt(), R = sc.nextInt();
        int[][] edges = new int[N][N];
        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                edges[i][j] = Integer.MAX_VALUE;
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < R; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            int l = sc.nextInt();
            int t = sc.nextInt();
            edges[s - 1][d - 1] = l;
            cost[s - 1][d - 1] = t;
        }

        System.out.println(solve(0, edges, K, cost));

    }
}
//5 6 7 1 2 2 4 2 4 3 3 3 4 2 4 1 3 4 1 4 6 2 1 3 5 2 0 5 4 3 2