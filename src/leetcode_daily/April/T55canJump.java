package leetcode_daily.April;

/**
 * Author:cafe3165
 * Date:2020-04-17
 */
public class T55canJump {

    public static boolean canJump(int[] nums) {
        int longest = 0, l = nums.length, last = 0;
        for (int i = 0; i < l - 1; i++) {
            longest = Math.max(longest, nums[i] + i);
            if (last == i) {
                last = longest;
            }

        }
        if (last < l - 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 3};

        System.out.println(canJump(nums));

    }
}