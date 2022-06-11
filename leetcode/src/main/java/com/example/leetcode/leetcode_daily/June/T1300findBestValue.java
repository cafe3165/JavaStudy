package com.example.leetcode.leetcode_daily.June;

import java.util.Arrays;

/**
 * Author:cafe3165
 * Date:2020-06-15
 */
public class T1300findBestValue {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int r = arr[n - 1];
        int ans = 0, diff = target;

        for (int i = 1; i <= r; ++i) {
            int index = Arrays.binarySearch(arr, i);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = prefix[index] + (n - index) * i;
            if (Math.abs(cur - target) < diff) {
                ans = i;
                diff = Math.abs(cur - target);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        T1300findBestValue t = new T1300findBestValue();
        int[] arr = {4, 3, 9};
        int target = 10;
        t.findBestValue(arr, target);

    }
}
