package leetcode__interview;

/**
 * Author:cafe3165
 * Date:2020-03-06
 */
public class Top53maxSubArray {
    public int maxSubArray(int[] nums) {
        int sum = 0, res =nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (sum  > 0) {
                sum += nums[i];

            } else {
                sum = nums[i];
            }
            res = Math.max(sum, res);
        }
        return res;
    }

    public static void main(String[] args) {
        Top53maxSubArray t = new Top53maxSubArray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        t.maxSubArray(nums);
    }

}
