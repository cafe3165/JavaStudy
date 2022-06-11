package com.example.leetcode.labuladong.HighFrequnt;

import java.util.Arrays;

public class T42rainwater {
    public int trap(int[] height) {
        int len = height.length;
        int sum = 0;
        int[] memo_l = new int[len], memo_r = new int[len];
        memo_l[0] = height[0];
        memo_r[len - 1] = height[len - 1];
        for (int i = 1; i < len; i++) {
            memo_l[i] = Math.max(memo_l[i - 1], height[i]);
        }
        for (int i = len - 2; i >= 0; i--) {
            memo_r[i] = Math.max(height[i], memo_r[i + 1]);
        }
        for (int i = 1; i < len - 1; i++) {
            sum += Math.min(memo_l[i], memo_r[i]) - height[i];
        }
        return sum;
    }

    public int trap2(int[] height) {

        int len = height.length;
        if (len == 0) {
            return 0;
        }
        int sum = 0;
        int l = 0, r = len - 1;
        int l_max = height[l], r_max = height[len - 1];

        while (l <= r) {
            l_max = Math.max(l_max, height[l]);
            r_max = Math.max(r_max, height[r]);
            if (l_max < r_max) {
                sum += l_max - height[l];
                l++;
            } else {
                sum += r_max - height[r];
                r--;
            }
        }
        return sum;
    }


    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        T42rainwater t = new T42rainwater();
        t.trap2(height);

    }
}
