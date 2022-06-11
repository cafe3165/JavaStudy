package com.example.leetcode.leetcode_list200;

import java.util.ArrayList;
import java.util.List;

public class T22_generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, "", 0, 0, n);
        return ans;

    }

    public void backTrack(List<String> ans, String cur, int left, int right, int max) {
        if (cur.length() == 2 * max) {
            ans.add(cur);
            return;
        }
//        if (right - left > 0) {
////            return;
////        }
        if (left < max) {
            backTrack(ans, cur + "(", left + 1, right, max);
        }
        if (right < left) {
            backTrack(ans, cur + ")", left, right + 1, max);
        }


    }

    public static void main(String[] args) {
        T22_generateParenthesis t = new T22_generateParenthesis();
        t.generateParenthesis(3);
    }
}
