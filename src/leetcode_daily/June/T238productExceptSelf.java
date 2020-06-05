package leetcode_daily.June;

/**
 * Author:cafe3165
 * Date:2020-06-04
 */
public class T238productExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] L = new int[len], R = new int[len];
        int[] res = new int[len];
        L[0] = 1;
        R[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            L[i] = L[i - 1] * nums[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            R[i] = R[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < len; i++) {
            res[i]=L[i]*R[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        productExceptSelf(nums);

    }
}
