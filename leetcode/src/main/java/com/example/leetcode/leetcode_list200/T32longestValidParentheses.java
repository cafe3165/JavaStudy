package com.example.leetcode.leetcode_list200;

import java.util.Stack;

/**
 * Author:cafe3165
 * Date:2020-06-07
 */
public class T32longestValidParentheses {
    public int longestValidParentheses(String s) {
    
        int len = s.length();
        if (len == 0 || len == 1) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = 0;
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            } else {
                if (s.charAt(i - 1) == '(') {
                    if (i - 2 >= 0) {
                        dp[i] = dp[i - 2] + 2;
                    } else {
                        dp[i] = 2;
                    }
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2;
                        if (i - dp[i - 1] - 2 >= 0) {
                            dp[i] = dp[i] + dp[i - dp[i - 1] - 2];
                        }
                    }
                }
            }
            res = Math.max(res, dp[i]);
        }


        return res;
    }

    public static void main(String[] args) {
        T32longestValidParentheses t = new T32longestValidParentheses();
        t.longestValidParentheses("()(())");

    }
}
