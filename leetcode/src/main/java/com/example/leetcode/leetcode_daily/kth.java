package com.example.leetcode.leetcode_daily;

import java.util.Random;

/**
 * Author:cafe3165
 * Date:2020-04-22
 */
public class kth {
    public static void main(String[] args) {
        int[] a = {4, 3, 8, 6, 1, 2};
        int n = 6;
        findkth(a, 0, a.length - 1, n);
        System.out.println(a[n - 1]);
    }

    private static void findkth(int[] a, int l, int r, int n) {
        if (l == r) {
            return;
        }
        int p = part(a, l, r);
        int m = p - l + 1;
        if (n == m) {
            return;
        } else if (n < m) {
            findkth(a, l, p - 1, n);
        } else {
            findkth(a, p + 1, r, n);
        }
    }

    private static int part(int[] a, int l, int r) {
        int tmp = a[l];
        while (l < r) {
            while (l < r && a[r] > tmp) {
                r--;
            }
            a[l] = a[r];
            while (l < r && a[l] <= tmp) {
                l++;
            }
            a[r] = a[l];
        }
        a[l] = tmp;
        return l;
    }
}
