package com.example.leetcode.leetcode_list400;

import java.util.Arrays;

/**
 * @description:
 * @author: huangzhiming04@meituan.com
 * @date: 2021/7/25 7:34 下午
 */
public class T581findUnsortedSubarray {
    public int findUnsortedSubarray2 (int[] nums) {
        int[] newNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(newNums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            if (nums[i] != newNums[i]) {
                break;
            }
            i++;
        }
        while (i < j) {
            if (nums[j] != newNums[j]) {
                break;
            }
            j--;
        }
        return i == j ? 0 : j - i + 1;
    }

    public int findUnsortedSubarray (int[] nums) {

        int i = 0, j = nums.length - 1;
        while (i < nums.length) {
            if (i + 1 < nums.length && nums[i] > nums[i + 1]) {
                break;
            }
            i++;
        }
        while (j >= 0) {
            if (j - 1 >= 0 && nums[j] < nums[j - 1]) {
                break;
            }
            j--;
        }
        return i >= j ? 0 : j - i + 1;
    }

    public static void main(String[] args) {
        //int[] nums = {2, 6, 4, 8, 10, 9, 15};
        int[] nums = {1, 2, 3, 4};
        T581findUnsortedSubarray t = new T581findUnsortedSubarray();
        t.findUnsortedSubarray(nums);
    }
}
