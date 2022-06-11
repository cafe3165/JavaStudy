package com.example.leetcode.leetcode_list200;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-06-05
 */
public class T60getPermutation {
    static boolean f = false;
    static int K;

    public static String getPermutation(int n, int k) {
        K = k;
        List<Integer> numR = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numR.add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[numR.size()];
        backTrack(numR, res, path, 0, numR.size(), used);
        StringBuilder sb = new StringBuilder();
        List<Integer> nums = res.get(k - 1);
        for (Integer i : nums) {
            sb.append(i);
        }
        return sb.toString();
    }

    private static void backTrack(List<Integer> num, List<List<Integer>> res, Deque<Integer> path
            , int depth, int len, boolean[] used) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            if (res.size() > K){
                f=true;
            }
                return;
        }
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.addLast(num.get(i));
                used[i] = true;
                backTrack(num, res, path, depth + 1, len, used);
                path.removeLast();
                used[i] = false;
                if(f){
                    break;
                }
            }
        }


    }


    public static void main(String[] args) {
        System.out.println(getPermutation(3, 3));
    }
}
