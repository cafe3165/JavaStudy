package com.example.leetcode.leetcode_daily;

import java.util.Stack;

/**
 * Author:cafe3165
 * Date:2020-04-05
 */
public class T739_ddz_dailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int len = T.length;
        if (len == 0) {
            return new int[]{};
        }
        if (len == 1) {
            return new int[]{0};
        }
        stack.push(0);
        int[] res = new int[len];
        for (int i = 1; i < len; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int tmp = stack.pop();
                res[tmp] = i - tmp;
            }
            stack.push(i);
        }

        return res;
    }

    public int[] dailyTemperatures2(int[] T) {
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.empty() && T[stack.peek()] <= T[i]) {
                stack.pop();
            }
            res[i] = stack.empty() ? 0 : stack.peek() - i;
            stack.push(i);
        }

        return res;

    }


    public static void ddz(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 2 * len - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i % len]) {
                stack.pop();
            }
            res[i % len] = stack.empty() ? -1 : stack.peek();
            stack.push(nums[i % len]);
        }
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        //[1, 1, 4, 2, 1, 1, 0, 0]
        //T739_ddz_dailyTemperatures t = new T739_ddz_dailyTemperatures();
        //t.dailyTemperatures2(T);
        ddz(new int[]{2, 1, 2, 4, 3});

    }
}
