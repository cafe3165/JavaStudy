package com.example.leetcode.leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-06-05
 */
public class T70climbStairs {
    public static int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        for (int i = 3; i <=n ; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 5;
        climbStairs(n);

    }
}
