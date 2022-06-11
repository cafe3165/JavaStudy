package com.example.leetcode.leetcode_daily.May;

/**
 * Author:cafe3165
 * Date:2020-05-19
 */
public class T680validPalindrome {
    public static int count = 0;

    public static boolean validPalindrome(String s) {
        return jude(s, 0, s.length() - 1, 1);
    }

    private static boolean jude(String s, int l, int r, int count) {
        if (l > r) {
            return true;
        }
        if (s.charAt(l) == s.charAt(r)) {
            return jude(s, l + 1, r - 1, count);
        }else{
            if (count == 0) {
                return false;
            }
            return jude(s, l, r - 1, count-1) || jude(s, l + 1, r, count-1);
        }
    }


    public static void main(String[] args) {
        String s = "abca";
        validPalindrome(s);

    }

}
