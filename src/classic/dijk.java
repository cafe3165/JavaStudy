package classic;

/**
 * Author:cafe3165
 * Date:2020-04-20
 */
public class dijk {
    public static int[] dijkstra(int v, int[][] edges) {
        int vexnum = edges.length;
        boolean st[] = new boolean[vexnum];
        int[] dis = new int[vexnum];

        for (int i = 0; i < vexnum; i++) {
            for (int j = i+1; j < vexnum; j++) {
                if(edges[i][j]==0){
                    edges[i][j]=Integer.MAX_VALUE;
                    edges[j][i]=Integer.MAX_VALUE;
                }
            }
        }
        for (int i = 0; i < vexnum; i++) {
            dis[i] = edges[v][i];
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

                }

            }


        }


        return dis;
    }

//    https://blog.csdn.net/qq_38410730/article/details/79587768
    public static void main(String[] args) {
        int max = Integer.MAX_VALUE;
        int[][] edges = {
                {0, max, 10, max, 30, 100},
                {max, 0, 5, max, max, max},
                {max, max, 0, 50, max, max},
                {max, max, max, 0, max, 10},
                {max, max, max, 20, 0, 60},
                {max, max, max, max, max, 0},

        };

        System.out.println( dijkstra(1, edges));

    }
}
