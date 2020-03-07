package leetcode_list200;

import java.util.Collections;
import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class T15_threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<Integer> Nums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> numList = new ArrayList<>();
        if (nums.length < 3) {
            return numList;
        }
        Collections.sort(Nums);

        for (int i = 0; i < Nums.size(); i++) {

            if (Nums.get(i) > 0) {
                return numList;
            }
            if (i > 0 && Nums.get(i).equals(Nums.get(i - 1))) {
                continue;
            }
            int L = i + 1, R = Nums.size() - 1;
            while (L < R) {
                List<Integer> res = new ArrayList<>();
                if (Nums.get(i) + Nums.get(L) + Nums.get(R) == 0) {
                    res.add(Nums.get(i));
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
                } else if (Nums.get(i) + Nums.get(L) + Nums.get(R) > 0) {
                    R--;
                } else {
                    L++;
                }

            }
        }

        return numList;
    }

    public static void main(String[] args) {
        T15_threeSum t = new T15_threeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        t.threeSum(nums);
    }
}
