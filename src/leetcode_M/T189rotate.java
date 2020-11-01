package leetcode_M;

/**
 * Author:cafe3165
 * Date:2020-11-01
 */
public class T189rotate {
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int n = k - (k / len) * len;
        change(nums, len - n, len - 1);
        change(nums, 0, len - n - 1);
        change(nums, 0, len - 1);
        System.out.println();
    }

    private static void change(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        rotate(nums, k);
    }
}
