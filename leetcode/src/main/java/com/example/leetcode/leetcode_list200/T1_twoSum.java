package com.example.leetcode.leetcode_list200;

public class T1_twoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        int[] tmp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i] = target - nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < tmp.length; j++) {
                if (nums[i] == tmp[j]) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        int[] r = twoSum(nums, target);
        System.out.println(r[0] + " " + r[1]);
    }
}
