package com.example.other;

import java.util.SortedMap;

/**
 * Author:cafe3165
 * Date:2023-03-05
 */
public class MergeSortTest {

    public void mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return ;
        }
        int mid = l + (r - l) / 2;
        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);
        merge(nums, l, mid, r);
    }

    private void merge(int[] nums, int l, int mid, int r) {
        int[] tmp = new int[nums.length];
        int ll = l;
        int rr = mid + 1;
        int index = l;

        while (ll <= mid && rr <= r) {
            if (nums[ll] <= nums[rr]) {
                tmp[index++] = nums[ll++];
            } else {
                tmp[index++] = nums[rr++];
            }
        }
        while (ll <= mid) {
            tmp[index++] = nums[ll++];
        }
        while (rr <= r) {
            tmp[index++] = nums[rr++];
        }

        for (int i = l; i <= r; i++) {
            nums[i] = tmp[i];
        }
    }




    public static void main(String[] args) {
        MergeSortTest m = new MergeSortTest();
        int[] nums = new int[]{4, 5, 8, 1, 7, 2, 6, 3};
        m.mergeSort(nums, 0, nums.length - 1);
        for (int num : nums) {
            System.out.println(num);
        }




















    }
}
