package com.example.leetcode.leetcode_daily.July;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class T350intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        int len1 = nums1.length, len2 = nums2.length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < len1; i++) {
            if (map.containsKey(nums1[i])) {
                map.merge(nums1[i], 1, Integer::sum);
            } else {
                map.put(nums1[i], 1);
            }
        }
        for (int i = 0; i < len2; i++) {
            if (map.containsKey(nums2[i]) && map.get(nums2[i]) > 0) {
                resList.add(nums2[i]);
                map.merge(nums2[i], -1, Integer::sum);
            }
        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        T350intersect t = new T350intersect();
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        t.intersect(nums1, nums2);

    }
}
