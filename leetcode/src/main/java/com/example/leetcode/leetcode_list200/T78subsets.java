package com.example.leetcode.leetcode_list200;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-05-26
 */
public class T78subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private static void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums={1,2,3};
        subsets(nums);

    }
}
