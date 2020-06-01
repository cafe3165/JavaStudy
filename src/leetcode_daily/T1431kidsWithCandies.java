package leetcode_daily;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-06-01
 */
public class T1431kidsWithCandies {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE, len = candies.length;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            max = Math.max(candies[i], max);
        }
        for (int i = 0; i < len; i++) {
            res.add(candies[i] + extraCandies >= max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;
        kidsWithCandies(candies, extraCandies);
    }
}
