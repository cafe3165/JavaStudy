package com.example.leetcode.leetcode_daily.April;

/**
 * Author:cafe3165
 * Date:2020-05-25
 */
public class T202isHappy {
    public static boolean isHappy(int n) {
        int slow = n, fast = Sum(n);
        while (slow != fast) {
            slow = Sum(slow);
            fast = Sum(Sum(fast));
        }
        return slow == 1;
    }

    public static int Sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        isHappy(19);

    }
}
