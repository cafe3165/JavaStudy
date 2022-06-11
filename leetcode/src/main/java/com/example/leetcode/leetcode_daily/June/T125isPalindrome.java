package com.example.leetcode.leetcode_daily.June;

/**
 * Author:cafe3165
 * Date:2020-06-19
 */
public class T125isPalindrome {
    public boolean isPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return true;
        }
        char[] chs = s.toCharArray();
        int l = 0, r = len - 1;
        while (l < r) {
            while (l <= r && !Character.isLetterOrDigit(chs[l])) {
                l++;
            }
            while (l <= r && !Character.isLetterOrDigit(chs[r])) {
                r--;
            }
            if (l < r) {
                if (Character.toLowerCase(chs[l]) != Character.toLowerCase(chs[r])){
                    return false;
                }
                l++;
                r--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = ".,";
        T125isPalindrome t = new T125isPalindrome();
        t.isPalindrome(s);
//        System.out.println('a' - 'A');

    }
}
