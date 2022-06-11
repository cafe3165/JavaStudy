package com.example.leetcode.leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-06-06
 */
public class T75sortColors {
    public static void sortColors2(int[] nums) {
        int len = nums.length;
        int[] colors = new int[3];
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                colors[0]++;
            } else if (nums[i] == 1) {
                colors[1]++;
            } else {
                colors[2]++;
            }
        }
        int index = 0;
        for (int i = 0; i < 3; i++) {
            while (colors[i] > 0) {
                nums[index++] = i;
                colors[i]--;
            }
        }

        System.out.println();
    }

    public static void sortColors(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        int l = -1;//定义左边索引位置
        int r = len - 1;//定义右边索引位置
        int cur = 0;//定义当前移动索引指针

        while (cur <= r) {//当前移动索引指针位置不能超过右索引指针访问位置
            if (nums[cur] == 0) {//如果当前访问元素是0
                l++;//要将一开始定义的-1变成0
                swap(nums, cur, l);
                cur++;
            } else if (nums[cur] == 1) {//如果当前访问元素是1
                cur++;
            } else {
                swap(nums, cur, r);//如果当前访问元素是2
                r--;
            }
        }
    }
    private static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColors(nums);
    }
}
