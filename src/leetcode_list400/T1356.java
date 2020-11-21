package leetcode_list400;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class T1356 {
    public static int[] sortByBits(int[] arr) {
        int[] bit = new int[10001];
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        bit[0] = 0;
        for (int i = 1; i <= 10000; i++) {
            bit[i] = bit[i >> 1] + (i & 1);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (bit[o1] - bit[o2] != 0) {
                    return bit[o1] - bit[o2];
                }
                return o1 - o2;
            }
        });
        int[] res = list.stream().mapToInt(Integer::valueOf).toArray();

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] res = sortByBits(arr);

    }

    private static int bitCount(int i) {
        // HD, Figure 5-2
        i = i - ((i >>> 1) & 0x55555555);
        i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
        i = (i + (i >>> 4)) & 0x0f0f0f0f;
        i = i + (i >>> 8);
        i = i + (i >>> 16);
        return i & 0x3f;
    }
}
