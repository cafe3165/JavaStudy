package com.example.leetcode.labuladong.AlgorithmThoght;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T77combine {
    List<List<Integer>> res = new ArrayList<>();
    int K;

    public List<List<Integer>> combine(int n, int k) {
        K = k;
        backTrack(1, n, 0, new LinkedList<>());
        return res;
    }

    private void backTrack(int start, int n, int depth, LinkedList<Integer> tmp) {
        if (depth == K) {
            res.add(new ArrayList<>(tmp));
            return ;
        }

        for (int i = start; i <= n; i++) {
            tmp.add(i);
            backTrack(i + 1, n, depth + 1, tmp);
            tmp.removeLast();
        }

    }


    public static void main(String[] args) {
        int n = 4, k = 2;
        T77combine t = new T77combine();
        t.combine(n, k);
    }
}
