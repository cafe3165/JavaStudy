package com.example.leetcode.leetcode_daily.July;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class T89grayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(0);
        if (n == 0) {
            return res;
        }
        res.add(1);
        if (n == 1) {
            return res;
        }
        int tmp = 2;
        while (tmp <= n) {
            int len = (int) Math.pow(2, tmp - 1);
            int[] reverse = new int[len];
            for (int i = len - 1; i >= 0; i--) {
                reverse[len - 1 - i] = res.get(i);
            }
            for (int i = 0; i < len; i++) {
                reverse[i] += Math.pow(2, tmp - 1);
                res.add(reverse[i]);
            }
            tmp++;
        }
        return res;

    }

    public static void main(String[] args) {
        T89grayCode t = new T89grayCode();
        t.grayCode(3);
    }
}
