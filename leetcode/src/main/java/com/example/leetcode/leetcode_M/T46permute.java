package com.example.leetcode.leetcode_M;

import java.util.LinkedList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-03-03
 */
public class T46permute {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backTrack(nums, track);
        return res;

    }

    void backTrack(int[] nums, LinkedList<Integer> track) {
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(track.contains(nums[i])){
                continue;
            }
            track.add(nums[i]);
            backTrack(nums,track);
            track.removeLast();
        }

    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        T46permute t = new T46permute();
        t.permute(nums);

    }
}
