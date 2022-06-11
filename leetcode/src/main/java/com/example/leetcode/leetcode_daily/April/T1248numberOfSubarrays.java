package com.example.leetcode.leetcode_daily.April;

/**
 * Author:cafe3165
 * Date:2020-04-21
 */
public class T1248numberOfSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        int res = 0;
        int left = 0, right = 0;
        int odd = 0;
        while (right < nums.length) {

            if ((nums[right++] & 1) == 1) {
                odd++;
            }
            if (odd == k) {
                int tmp = right;
                while (right<nums.length&&(nums[right] & 1) == 0) {
                    right++;
                }
                int righteven = right - tmp;
                int lefteven = 0;
                while ((nums[left] & 1) == 0) {
                    lefteven++;
                    left++;
                }
                res += (lefteven + 1) * (righteven + 1);
                left++;
                odd--;
            }
        }
        return res;
    }

    public static void main(String[] args) {

        T1248numberOfSubarrays t = new T1248numberOfSubarrays();
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        t.numberOfSubarrays(nums, k);

    }
}
