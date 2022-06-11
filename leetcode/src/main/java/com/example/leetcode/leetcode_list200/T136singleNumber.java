package com.example.leetcode.leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-05-14
 */
public class T136singleNumber {
    public static int singleNumber(int[] nums) {
        int res=0;
        for (int i = 0; i < nums.length; i++) {
            res^=nums[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] a={4,1,2,1,2};
        System.out.println(singleNumber(a));

    }
}
