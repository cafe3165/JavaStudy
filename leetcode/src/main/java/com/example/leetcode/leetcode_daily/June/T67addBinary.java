package com.example.leetcode.leetcode_daily.June;

public class T67addBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();
        char[] chsa = a.toCharArray(), chsb = b.toCharArray();
        int i = a.length() - 1, j = b.length() - 1;
        int ca = 0;
        for (; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? chsa[i] - '0' : 0;
            sum += j >= 0 ? chsb[j] - '0' : 0;
            res.append(sum % 2);
            ca = sum / 2;
        }
        res.append(ca == 1 ? ca : "");

        return res.toString();
    }

    public static void main(String[] args) {
        String a = "10", b = "1011";
        T67addBinary t = new T67addBinary();
        t.addBinary(a, b);

    }
}
