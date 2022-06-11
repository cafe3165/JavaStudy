package com.example.leetcode.leetcode_list400;

/**
 * Author:cafe3165
 * Date:2021-03-11
 */
public class T461hammingDistance {
    public static int hammingDistance(int x, int y) {
        int z = x ^ y;
        return Integer.bitCount(z);
    }

    public static void main(String[] args) {
        int x = 1, y = 4;
        System.out.println(hammingDistance(x, y));
    }
}
