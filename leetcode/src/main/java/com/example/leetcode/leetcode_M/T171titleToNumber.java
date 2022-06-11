package com.example.leetcode.leetcode_M;

/**
 * Author:cafe3165
 * Date:2020-11-01
 */
public class T171titleToNumber {
    public static int titleToNumber(String s) {
        int len = s.length();
        if (len == 1) {
            return s.charAt(0) - 'A' + 1;
        }
        int num = 0;
        for (int i = len - 1; i >= 0; i--){
            num += (s.charAt(i) - 'A' + 1) * Math.pow(26 , len - i - 1) ;
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "AAA";
//        26*26 + 25

        titleToNumber(s);
    }
}
