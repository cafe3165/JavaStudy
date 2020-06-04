package leetcode_daily.March;

import java.util.Arrays;

/**
 * Author:cafe3165
 * Date:2020-03-14
 */
public class T300lengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int[] DP = new int[nums.length];
        Arrays.fill(DP, 1);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    DP[i] = Math.max(DP[j] + 1, DP[i]);
                }
            }
            res = Math.max(DP[i], res);
        }

        return res;
    }

    public static void main(String[] args) {
        T300lengthOfLIS t = new T300lengthOfLIS();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        t.lengthOfLIS(nums);
    }
}
