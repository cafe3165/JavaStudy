package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class T18_fourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<Integer> Nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> numList = new ArrayList<>();
        if (nums.length < 4) {
            return numList;
        }
        Collections.sort(Nums);

        for (int i = 0; i < Nums.size() - 3; i++) {
//            重复的要跳过？
            if (i > 0 && Nums.get(i).equals(Nums.get(i - 1))) {
                continue;
            }
            for (int j = i + 1; j < Nums.size() - 2; j++) {

                if (j > i + 1 && Nums.get(j).equals(Nums.get(j - 1))) {
                    continue;
                }

                int L = j + 1, R = Nums.size() - 1;
                while (L < R) {
                    List<Integer> res = new ArrayList<>();
                    if (Nums.get(i) +Nums.get(j)+ Nums.get(L) + Nums.get(R) == target) {
                        res.add(Nums.get(i));
                        res.add(Nums.get(j));
                        res.add(Nums.get(L));
                        res.add(Nums.get(R));

                        while (L < R && Nums.get(L).equals(Nums.get(L + 1))) {
                            L++;
                        }
                        while (L < R && Nums.get(R).equals(Nums.get(R - 1))) {
                            R--;
                        }
                        L++;
                        R--;
                        numList.add(res);
                    } else if (Nums.get(i) +Nums.get(j) + Nums.get(L) + Nums.get(R) > target) {
                        R--;
                    } else {
                        L++;
                    }

                }
            }






        }

        return numList;


    }

    public static void main(String[] args) {
//        int[] nums = {1, 0, -1, 0, -2, 2};
        int[] nums = {0,0,0,0};
        int target = 0;
        T18_fourSum t = new T18_fourSum();
        t.fourSum(nums, target);

    }
}
