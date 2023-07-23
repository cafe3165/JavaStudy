package com.example.m;

/**
 * Author:cafe3165
 * Date:2023-04-01
 */
public class HW_3 {

    public static int INVALID = -1;

    public int search(int[] nums, int target) {
        if (nums == null) {
            return INVALID;
        }
        int index = search(nums, 0 , nums.length - 1, target);
        if (index < 0 || index >= nums.length || nums[index] != target) {
            return INVALID;
        }
        return index;

    }

    private int search(int[] nums, int l, int r, int target) {
        if (l == r) {
            return l;
        }
        int mid = l + (r- l) / 2;

        if (nums[mid] > target) {
            System.out.println(l + " " + mid);
            return search(nums, l, mid, target);
        } else if (nums[mid] < target) {
            System.out.println(mid + 1 + " " + r);
            return search(nums, mid + 1, r, target);
        } else {
            return mid;
        }

    }





    public static void main(String[] args) {

        HW_3 h = new HW_3();

        System.out.println(h.search(new int[]{-1,0,3,5,9,12}, 10));
        System.out.println(h.search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(h.search(new int[]{-1,0,3,5,9,12}, -2));
        System.out.println(h.search(new int[]{-1,0,3,5,9,12}, 13));

    }
}
