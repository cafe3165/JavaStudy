package com.example.leetcode.leetcode_list200;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-06-04
 */
public class T39combinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(res, candidates, 0, candidates.length, target, new ArrayDeque<>());
        return res;
    }

    private static void dfs(List<List<Integer>> res, int[] candidates,
                            int begin, int len, int resNum, Deque<Integer> path
    ) {
        if (resNum == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < len; i++) {
            if (resNum - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            dfs(res, candidates, i, len, resNum - candidates[i], path);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        combinationSum(candidates, target);

    }
}
