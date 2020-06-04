package leetcode_daily.May;

/**
 * Author:cafe3165
 * Date:2020-05-10
 */
public class T45jump {
    public static int jump(int[] nums) {
        int step = 0;
        int longest = 0, end = 0;
        for (int i = 0; i < nums.length-1; i++) {
            longest = Math.max(i + nums[i], longest);
            if (i == end) {
                end = longest;
                step++;
            }
        }
        return step;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4, 2, 1};
        int step = jump(nums);
        System.out.println(step);
    }
}
