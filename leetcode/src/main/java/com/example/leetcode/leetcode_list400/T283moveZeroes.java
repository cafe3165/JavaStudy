package com.example.leetcode.leetcode_list400;

/**
 * Author:cafe3165
 * Date:2020-06-20
 */
public class T283moveZeroes {
    public void moveZeroes(int[] nums) {
        int count0 = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count0++;
                continue;
            } else {
                nums[index] = nums[i];
                index++;
            }
        }
        while (count0 > 0) {
            nums[index] = 0;
            index++;
            count0--;
        }

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        T283moveZeroes t = new T283moveZeroes();
        t.moveZeroes(nums);

    }
}
