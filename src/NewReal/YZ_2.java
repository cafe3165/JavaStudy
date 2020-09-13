package NewReal;

import java.util.Arrays;

/**
 * Author:cafe3165
 * Date:2020-09-11
 */
public class YZ_2 {
    /**
     * 最少移动次数
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int minMoves(int[] nums) {
        // write code here
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            count += nums[j] - nums[i];
        }
        return count;
    }


    public static void main(String[] args) {
        YZ_2 yz = new YZ_2();
        int[] nums = {1, 2, 4};
        System.out.println(yz.minMoves(nums));
    }
}
