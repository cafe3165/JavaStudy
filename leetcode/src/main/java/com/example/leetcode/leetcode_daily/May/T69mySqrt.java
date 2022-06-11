package com.example.leetcode.leetcode_daily.May;

/**
 * Author:cafe3165
 * Date:2020-05-14
 */
public class T69mySqrt {
    public static int mySqrt(int x) {
        long l = 0, h = x / 2 + 1;
        while (l < h) {
            long mid = (l + h + 1) >>> 1;
            long pow = mid * mid;
            if (pow > x) {
                h = mid - 1;
            } else {
                l = mid;
            }
        }
        return (int) l;
    }

    public static int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        double l = Math.log(x);
        int ans = (int) Math.exp(0.5 * l);
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;

    }

    public static int mySqrt3(int x) {
        if (x == 0) {
            return x;
        }
        int ans = -1;
        int l = 0, r = x;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        int x = 8;
        System.out.println(mySqrt2(x));

    }
}
