package com.example.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2023-03-04
 */
public class AllTest {

    private static List<List<Integer>> res = new ArrayList<>();

    private static boolean[] visited;

    public List<List<Integer>> per(int[] nums) {
        visited = new boolean[nums.length];
        dfs(nums, new ArrayList<>());

        return res;
    }


    private void dfs(int[] nums, List<Integer> stack) {

        if (stack.size() == nums.length) {
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            stack.add(nums[i]);
            dfs(nums, stack);
            visited[i] = false;
            stack.remove(stack.size() - 1);
        }

    }


    public static void main(String[] args) {

        AllTest a = new AllTest();
        List<List<Integer>> res = a.per(new int[]{1, 2, 3});

        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.print(integer);
            }
            System.out.println();
        }

    }
}
