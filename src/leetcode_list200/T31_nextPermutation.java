package leetcode_list200;

import java.util.Arrays;

public class T31_nextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null) {
            return;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                Arrays.sort(nums, i, nums.length);
                for (int j = i; j < nums.length; j++) {
                    if (nums[i - 1] < nums[j]) {
                        int temp = nums[j];
                        nums[j] = nums[i - 1];
                        nums[i - 1] = temp;
                        return;
                    }
                }
            }
            if (i == 1) {
                Arrays.sort(nums);
                return;
            }
        }
    }

    public static void main(String[] args) {
        T31_nextPermutation t = new T31_nextPermutation();
        int[] nums = {1, 7, 8, 10, 9, 3, 0};
        t.nextPermutation(nums);
//        System.out.println("666");


    }
}
