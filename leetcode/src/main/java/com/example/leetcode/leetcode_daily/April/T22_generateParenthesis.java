package com.example.leetcode.leetcode_daily.April;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-04-09
 */
public class T22_generateParenthesis {
//    public static List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(n, n, "",res);


        return res;
    }

    private void dfs(int left, int right, String br,List<String> res) {
        if (left == 0 && right == 0) {
            res.add(br);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(left - 1, right, br + "(",res);
        }
        if (right > 0) {
            dfs(left, right - 1, br + ")",res);
        }


    }

    public static void main(String[] args) {
        T22_generateParenthesis t = new T22_generateParenthesis();
        int n = 1;
        t.generateParenthesis(n);

    }
}
