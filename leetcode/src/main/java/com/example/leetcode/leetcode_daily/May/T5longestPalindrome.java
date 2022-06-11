package com.example.leetcode.leetcode_daily.May;

/**
 * Author:cafe3165
 * Date:2020-05-21
 */
public class T5longestPalindrome {
    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int maxLen = 1;
        int begin=0;
        boolean[][] dp = new boolean[len][len];
        char[] chs = s.toCharArray();
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }


        for (int j = 1; j < len; j++) {
            for (int i = 0; i < j; i++) {
                if (chs[i] != chs[j]) {
                    dp[i][j] = false;
                } else {
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen=j-i+1;
                    begin=i;
                }

            }

        }

        return s.substring(begin,begin+maxLen);
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
