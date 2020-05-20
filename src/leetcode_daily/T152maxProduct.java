package leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-05-18
 */
public class T152maxProduct {
    public static int maxProduct(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = dp[0][1] = nums[0];
        int Max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][1]);
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][0]);
            } else {
                dp[i][1] = Math.max(nums[i], nums[i] * dp[i - 1][0]);
                dp[i][0] = Math.min(nums[i], nums[i] * dp[i - 1][1]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            Max = Math.max(Max, dp[i][1]);
        }

        return Max;

    }

    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};
        maxProduct(nums);

    }
}
