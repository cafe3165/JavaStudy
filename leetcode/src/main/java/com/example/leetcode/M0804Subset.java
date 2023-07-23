package com.example.leetcode;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2023-02-13
 */
public class M0804Subset {

    public static List<List<Integer>> list = new ArrayList<>();
    public static List<Integer> track = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(Arrays.stream(nums).boxed().toArray(), (o1, o2) -> 1);

        backTrace(nums, 0);
        return list;
    }

    public void backTrace(int[] nums, int start){
        list.add(new ArrayList<>(track));
        for (int i = start; i < nums.length; i++) {
            track.add(nums[i]);
            backTrace(nums, i + 1);
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        M0804Subset s = new M0804Subset();
        Integer[] nums = new Integer[]{1, 2, 2};
        List<List<Integer>> res = s.subsets(Arrays.stream(nums).mapToInt(Integer::valueOf).toArray());

        for (List<Integer> re : res) {
            System.out.println(JSONArray.fromObject(re).toString());
        }

        Arrays.sort(nums, (o1, o2) -> -1);

        System.out.println(JSONArray.fromObject(nums).toString());


    }

}
