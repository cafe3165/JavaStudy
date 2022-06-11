package com.example.leetcode.leetcode_daily.April;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-04-16
 */
public class T56merge {
    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[][]{};
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               return o1[0]-o2[0];
            }
        });
        List<int[]> reslist = new ArrayList<>();
        reslist.add(intervals[0]);
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= reslist.get(index)[1]) {
                int[] tmp = reslist.get(index);
                reslist.remove(index);
                tmp[1] = Math.max(intervals[i][1], tmp[1]);
                reslist.add(tmp);
            } else {
                reslist.add(intervals[i]);
                index++;
            }
        }

        return reslist.toArray(new int[reslist.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(intervals);

    }
}
