package leetcode_daily.April;

/**
 * Author:cafe3165
 * Date:2020-05-20
 */
public class M56singleNumbers {
    public static int[] singleNumbers(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        int div = 1;
        while ((res & div) == 0) {
            div <<= 1;
        }
        int a = 0, b = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & div) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }
        return new int[]{a, b};
    }

    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 6};
        singleNumbers(nums);

    }
}
