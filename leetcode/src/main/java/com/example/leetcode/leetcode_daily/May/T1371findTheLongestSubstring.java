package com.example.leetcode.leetcode_daily.May;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * Author:cafe3165
 * Date:2020-05-20
 */
public class T1371findTheLongestSubstring {
    public static int findTheLongestSubstring(String s) {
        int res = 0, status = 0, n = s.length();
        int[] pos = new int[1 << 5];
        Arrays.fill(pos, -1);
        pos[0] = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                status ^= (1 << 0);
            } else if (ch == 'e') {
                status ^= (1 << 1);
            } else if (ch == 'i') {
                status ^= (1 << 2);
            } else if (ch == 'o') {
                status ^= (1 << 3);
            } else if (ch == 'u') {
                status ^= (1 << 4);
            }
            if(pos[status]!=-1){
                res=Math.max(res,i+1-pos[status]);
            }else{
                pos[status]=i+1;
            }


        }
        return res;
    }

    public static void main(String[] args) {
        String s = "leetcodeisgreat";
        int l = findTheLongestSubstring(s);
        System.out.println(l);
    }
}
