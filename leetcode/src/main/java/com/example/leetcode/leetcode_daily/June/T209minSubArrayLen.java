package com.example.leetcode.leetcode_daily.June;

public class T209minSubArrayLen {
    public int minSubArrayLen2(int s, int[] nums) {
        int len = nums.length;
        int[] num = new int[len + 1];
        int res = Integer.MAX_VALUE;
        num[0] = 0;
        for (int i = 1; i < num.length; i++) {
            num[i] = nums[i - 1] + num[i - 1];
        }

        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[j] - num[i];
                if (sum >= s) {
                    res = Math.min(res, j - i);
                }
            }
        }


        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public int minSubArrayLen(int s, int[] nums) {
        int res = Integer.MAX_VALUE;
        int sum = 0;
        int l = 0, r = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= s) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l];
                l++;
            }
            r++;
        }
        return res;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        T209minSubArrayLen t = new T209minSubArrayLen();
        t.minSubArrayLen(s, nums);
    }
}
