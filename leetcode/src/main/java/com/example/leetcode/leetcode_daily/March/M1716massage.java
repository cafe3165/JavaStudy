package com.example.leetcode.leetcode_daily.March;

/**
 * Author:cafe3165
 * Date:2020-03-24
 */
public class M1716massage {
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        dp[1] = nums[1];
//        2, 1, 4, 5, 3, 1, 1, 3
        int max=0;
        for (int i = 2; i < nums.length; i++) {
            for (int j = 0; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                if(dp[i]>max){
                    max=dp[i];
                }
            }

        }


        return Math.max(max,Math.max(dp[0],dp[1]));
    }

    public static void main(String[] args) {
        M1716massage m = new M1716massage();
//        int[] nums = {2, 1, 4, 5, 3, 1, 1, 3};
        int[] nums = {2,7,9,3,1};
        m.massage(nums);
    }
}
