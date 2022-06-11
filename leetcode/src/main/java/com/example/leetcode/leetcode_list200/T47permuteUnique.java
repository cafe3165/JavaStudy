package com.example.leetcode.leetcode_list200;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-06-04
 */
public class T47permuteUnique {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        // 首先是特判
        int len = nums.length;
        // 使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();

        dfs(nums, len, 0, path, used, res);
        return res;
    }

    private static void dfs(int[] nums, int len, int depth,
                            Deque<Integer> path, boolean[] used,
                            List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            // 剪枝条件：i > 0 是为了保证 nums[i - 1] 有意义
            // 写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, path, used, res);
            // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
            used[i] = false;
            path.removeLast();

        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        permuteUnique(nums);
    }
}
