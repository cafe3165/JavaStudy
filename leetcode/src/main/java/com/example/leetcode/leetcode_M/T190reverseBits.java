package com.example.leetcode.leetcode_M;

/**
 * Author:cafe3165
 * Date:2020-12-14
 */
public class T190reverseBits {
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        Integer N = n;
        int m = Integer.reverse(n);
        System.out.println(Integer.toBinaryString(m));
        return m;

    }

    public static void main(String[] args) {
        System.out.println(reverseBits(-3));
    }
}
