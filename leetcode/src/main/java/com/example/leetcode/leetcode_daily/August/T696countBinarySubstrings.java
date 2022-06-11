package com.example.leetcode.leetcode_daily.August;

import java.util.ArrayList;
import java.util.List;

public class T696countBinarySubstrings {
    public int countBinarySubstrings(String s) {
        List<Integer> list = new ArrayList<>();
        int pre = 0, len = s.length();
        int res=0;

        while (pre < len) {
            int count = 0;
            char c = s.charAt(pre);
            while (pre < len && c == s.charAt(pre)) {
                pre++;
                count++;
            }
            list.add(count);
        }

        for (int i = 0; i < list.size()-1; i++) {
           res+=Math.min(list.get(i),list.get(i+1));
        }
        return res;

    }

    public static void main(String[] args) {
        String s = "00110011";
        T696countBinarySubstrings t = new T696countBinarySubstrings();
        t.countBinarySubstrings(s);

    }
}
