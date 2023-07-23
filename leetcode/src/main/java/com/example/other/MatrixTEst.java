package com.example.other;

/**
 * Author:cafe3165
 * Date:2023-06-03
 */
public class MatrixTEst {

    public static void main(String[] args) {
        String s = "babab";
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        int max = 0;
        int l = 0;
        int r = 0;


       for (int j = 0; j < n; j++) {
           for (int i = 0; i <= j; i++) {
               if (i == j) {
                   dp[i][j] = true;
                   continue;
               }
               if (s.charAt(i) == s.charAt(j)) {
                   dp[i][j] = dp[i + 1][j - 1];
                   if (j - i + 1 > max) {
                       max = j - i + 1;
                       l = i;
                       r = j;
                   }
               }
           }
       }



        System.out.println("res:" + s.substring(l, r + 1));

        for (boolean[] booleans : dp) {
          System.out.println();
            for (boolean aBoolean : booleans) {
                System.out.print(aBoolean + ",");
            }
        }
    }
}
