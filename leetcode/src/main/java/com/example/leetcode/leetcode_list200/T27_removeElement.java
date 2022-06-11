package com.example.leetcode.leetcode_list200;

public class T27_removeElement {
    public int removeElement(int[] nums, int val) {

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        T27_removeElement t = new T27_removeElement();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
//        快慢指针（双指针）
        t.removeElement(nums, val);

    }
}
