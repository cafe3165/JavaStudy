package leetcode_M;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Author:cafe3165
 * Date:2020-12-17
 */
public class T179largestNumber {
    public static String largestNumber(int[] nums) {
        IntStream intStream = Arrays.stream(nums);
        Stream<Integer> integerStream = intStream.boxed();
        Integer[] Nums = integerStream.toArray(Integer[]::new);
        Arrays.sort(Nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String n1 = o1.toString();
                String n2 = o2.toString();
                return (n2 + n1).compareTo(n1 + n2);
            }
        });
        if (Nums[0] == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : Nums) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));
    }
}
