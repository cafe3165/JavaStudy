package com.example.leetcode.leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-06-05
 */
public class T29divide {
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (divisor == -1) {
            if (dividend > Integer.MIN_VALUE) {
                return -dividend;
            } // 只要不是最小的那个整数，都是直接返回相反数就好啦
            return Integer.MAX_VALUE;// 是最小的那个，那就返回最大的整数啦
        }
        long a = dividend;
        long b = divisor;
        int sign = 1;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            sign = -1;
        }
        a = a > 0 ? a : -a;
        b = b > 0 ? b : -b;
        int res = (int)div(a, b);
        return sign==1?res:-res;
    }

    private static long div(long a, long b) {
        if (a < b) {
            return 0;
        }
        long count = 1;
        long tmpb = b;
        while ((tmpb + tmpb) <= a) {
            count += count;
            tmpb += tmpb;
        }
        return count + div(a - tmpb, b);

    }


    public static void main(String[] args) {
        System.out.println(divide(7, -2));
    }
}
