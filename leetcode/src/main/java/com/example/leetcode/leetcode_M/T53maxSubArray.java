package com.example.leetcode.leetcode_M;

/**
 * Author:cafe3165
 * Date:2020-03-06
 */
public class T53maxSubArray {
    public int maxSubArray(int[] nums) {
        int sum = 0, res =nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum  > 0) {
                sum += nums[i];

            } else {
                sum = nums[i];
            }
            res = Math.max(sum, res);
        }
        return res;
    }

    public static void main(String[] args) {
        T53maxSubArray t = new T53maxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        t.maxSubArray(nums);
    }

}
