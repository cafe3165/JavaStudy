package com.example.leetcode.leetcode_daily.May;

/**
 * Author:cafe3165
 * Date:2020-05-26
 */
public class T287findDuplicate {
    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        do {
            slow = nums[slow];
            fast = nums[fast];
        } while (slow != fast);
            return slow;

    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 6, 6, 2, 3};
        findDuplicate(nums);

    }
}
