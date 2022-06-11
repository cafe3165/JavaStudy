package com.example.leetcode.leetcode_list200;

import java.util.*;

import java.util.stream.Collectors;

public class T15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> numList = new ArrayList<>();
        if (nums.length < 3) {
            return numList;
        }
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return numList;
            }
            if (i > 0 && nums[i] == (nums[i - 1])) {
                continue;
            }
            int L = i + 1, R = len - 1;
            while (L < R) {
                List<Integer> res = new ArrayList<>();
                if (nums[i] + nums[L] + nums[R] == 0) {
                    res.add(nums[i]);
                    res.add(nums[L]);
                    res.add(nums[R]);

                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                    numList.add(res);
                } else if (nums[i] + nums[L] + nums[R] > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return numList;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> numList = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return numList;
        }
        Arrays.sort(nums);
        Set<Integer> set = new HashSet<>(len);
        for (int i = 0; i < len; i++) {
            set.add(-1 * nums[i]);
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                return numList;
            }
            if (i > 0 && nums[i] == (nums[i - 1])) {
                continue;
            }
            for (int j = 1; j < len; j++) {
                int num = nums[i] + nums[j];
                if (set.contains(num) && i != j) {

                    List<Integer> tmp = new ArrayList<>(3);
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(-num);
                    numList.add(tmp);

                }
            }
        }
        return numList;
    }


    public static void main(String[] args) {
        T15_threeSum t = new T15_threeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        t.threeSum2(nums);
    }
}
