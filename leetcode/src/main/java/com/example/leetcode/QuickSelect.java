package com.example.leetcode;

import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

/**
 * Author:cafe3165
 * Date:2023-03-30
 */
public class QuickSelect {

    public static int kThMax(int[] nums, int k) {
        return resolve(nums, 0, nums.length - 1, k);
    }

    private static int resolve(int[] nums, int l, int r, int k) {

        int i = l;
        int j = r;
        int pivot = nums[l];
        while (i < j) {
            while (nums[j] >= pivot && i < j) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
            }
            while (nums[i] <= pivot && i < j) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
            }
        }
        nums[i] = pivot;
        if (r - k + 1 > i) {
            return resolve(nums, i + 1, r, k);
        } else if (r - k + 1 < i) {
            return resolve(nums, l, i - 1, k - (r - i + 1));
        } else {
            return nums[i];
        }
    }


    public static void main(String[] args) {

//         5, 8, 3, 7, 1, 9

//
        int[] nums = new int[]{5, 8, 3, 7, 1, 9};
        for (int i = 1; i <= nums.length; i++) {
            System.out.println("第" + i + "大" + kThMax(nums, i));

        }

    }


}
