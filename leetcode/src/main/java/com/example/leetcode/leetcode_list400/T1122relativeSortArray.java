package com.example.leetcode.leetcode_list400;

import java.util.*;

public class T1122relativeSortArray {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] a2 = new int[arr2.length];
        int[] res = new int[arr1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], i);
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr1.length; i++) {
            int cur = arr1[i];
            if (map.containsKey(cur)) {
                a2[map.get(cur)]++;
            } else {
                list.add(cur);
            }
        }
        int idx = 0;
        for (int i = 0; i < a2.length; i++) {
            while (a2[i] > 0) {
                res[idx++] = arr2[i];
                a2[i]--;
            }
        }
        Collections.sort(list);
        for (int num: list) {
            res[idx++] = num;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, arr2 = {2, 1, 4, 3, 9, 6};
        relativeSortArray(arr1, arr2);
    }
}
