package com.example.leetcode.leetcode_daily;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

/**
 * Author:cafe3165
 * Date:2020-05-28
 */
public class T213rob2 {
    public static int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int rob1 = Myrob(Arrays.copyOfRange(nums, 0, len - 1));
        int rob2 = Myrob(Arrays.copyOfRange(nums, 1, len));
        return Math.max(rob1, rob2);


    }

    public static int Myrob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }

        return dp[len];
    }


    public static void main(String[] args) {
        int[] nums = {1, 20, 22};

        System.out.println(rob(nums));

    }
}
