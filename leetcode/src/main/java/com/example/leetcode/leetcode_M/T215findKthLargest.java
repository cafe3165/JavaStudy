package com.example.leetcode.leetcode_M;

/**
 * Author:cafe3165
 * Date:2020-12-14
 */
public class T215findKthLargest {
    public static int findKthLargest(int[] nums, int k) {
        int res = 0;
        int len = nums.length;
        int l = 0, r = len - 1;
        while (true) {
            int index = find(nums, l, r);
            if (index + k < len) {
                l = index + 1;
            } else if (index + k > len) {
                r = index - 1;
            } else {
                res = nums[index];
                break;
            }
        }
        return res;
    }

    private static int find(int[] nums, int left, int right) {
        int pivot = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] > pivot) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }

            while (i < j && nums[i] < pivot) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }

        }
        nums[j] = pivot;

        return j;
    }


    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 4;
        int res = findKthLargest(nums, k);
        System.out.println(res);
    }
}
