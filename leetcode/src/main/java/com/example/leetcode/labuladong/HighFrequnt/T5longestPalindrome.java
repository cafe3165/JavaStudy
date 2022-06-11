package com.example.leetcode.labuladong.HighFrequnt;

public class T5longestPalindrome {
    public String longestPalindrome(String s) {
        int l = s.length();
        String res = "";
        for (int i = 0; i < l; i++) {
            String r1 = find(s, i, i);
            String r2 = find(s, i, i + 1);
            String tmp = r1.length() > r2.length() ? r1 : r2;
            res = res.length() > tmp.length() ? res : tmp;
        }
        return res;

    }

    public String find(String s, int l, int r) {
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }else{
                break;
            }
        }
        return s.substring(l+1, r);
    }

    public static void main(String[] args) {
        String s = "babad";

        T5longestPalindrome t = new T5longestPalindrome();
        t.longestPalindrome(s);
    }
}
