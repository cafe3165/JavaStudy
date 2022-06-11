package com.example.leetcode.leetcode_list200;

public class T26_removeDuplicates {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }


    public static void main(String[] args) {
        T26_removeDuplicates t = new T26_removeDuplicates();
        int[] nums = {1, 1, 1,2, 2, 3};
        t.removeDuplicates(nums);
    }
}
