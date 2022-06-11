package com.example.leetcode.leetcode_daily.August;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-08-09
 */
public class T93restoreIpAddresses {
    private int[] seg = new int[4];
    private int len;
    private List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        char[] chs = s.toCharArray();
        len = s.length();
        backtracking(chs, 0, 0);
        return res;
    }

    private void backtracking(char[] chs, int depth, int start) {
        if (depth == 4) {
            if (start != len) {
                return;
            } else {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 4; i++) {
                    sb.append(seg[i]);
                    if (i != 3) {
                        sb.append(".");
                    }
                }
                res.add(sb.toString());
            }
            return;
        }
        if (start == len) {
            return;
        }
        if (chs[start] == '0') {
            seg[depth] = 0;
            backtracking(chs, depth + 1, start + 1);
        }
        int tmp = 0;
        for (int i = start; i < len; i++) {
            tmp = tmp * 10 + (chs[i] - '0');
            if (tmp > 0 && tmp <= 255) {
                seg[depth] = tmp;
                backtracking(chs, depth + 1, i + 1);
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) {
        String s = "25525511135";
        T93restoreIpAddresses t = new T93restoreIpAddresses();
        t.restoreIpAddresses(s);

    }
}
