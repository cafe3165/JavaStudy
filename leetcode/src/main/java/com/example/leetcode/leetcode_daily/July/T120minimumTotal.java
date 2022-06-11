package com.example.leetcode.leetcode_daily.July;

import java.util.ArrayList;
import java.util.List;

public class T120minimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            List<Integer> curLayer = triangle.get(i);
            int n = curLayer.size();
            for (int j = 0; j < n; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + curLayer.get(j);
                    continue;
                }
                if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + curLayer.get(i);
                    continue;
                }
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + curLayer.get(j);
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            res = Math.min(res, dp[m - 1][i]);
        }

        return res;
    }
//         [2],
//         [3,4],
//         [6,5,7],
//         [4,1,8,3]

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<Integer>() {{
            add(2);
        }});
        triangle.add(new ArrayList<Integer>() {{
            add(3);
            add(4);
        }});
        triangle.add(new ArrayList<Integer>() {{
            add(6);
            add(5);
            add(7);
        }});
        triangle.add(new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }});
        T120minimumTotal t = new T120minimumTotal();
        t.minimumTotal(triangle);

    }
}
