package leetcode_list200.personal;

/**
 * Author:cafe3165
 * Date:2020-04-18
 */
public class com_2 {
    public static int numWays2(int n, int[][] relation, int k) {
        int res = 0, tk = k;
        boolean[] vis = new boolean[relation.length];
        int[] begin = relation[0];
        int[] cur = new int[]{begin[0], begin[1]};
        vis[0] = true;

        for (int i = 1; i < relation.length; i++) {
            if (!vis[i] && relation[i][0] == cur[1] && tk > 1) {
                vis[i] = true;
                tk--;
                cur = relation[i];
                if (relation[i][1] == n - 1) {
                    res++;
                    break;
                }
            }
        }
        tk = k;


        return res;
    }

    public static int numWays(int n, int[][] relation, int k) {
        int res=0;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < relation.length; j++) {
                if(relation[j][1]==i){
                    dp[0][i]++;
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        int[][] relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        numWays(5, relation, 3);
    }
}
