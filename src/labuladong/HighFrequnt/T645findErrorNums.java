package labuladong.HighFrequnt;

/**
 * Author:cafe3165
 * Date:2020-08-01
 */
public class T645findErrorNums {
    public int[] findErrorNums(int[] nums) {
        int len = nums.length;
        int dup = 0, non = 0;
        for (int i = 0; i < len; i++) {
            int num = Math.abs(nums[i]);
            if (nums[num - 1] < 0) {
                dup = num;
            } else {
                nums[num - 1] *= -1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                non = i;
            }
        }
        int[] res = new int[2];
        res[0] = dup;
        res[1] = non + 1;
        return res;

    }

    public static void main(String[] args) {
        T645findErrorNums t = new T645findErrorNums();
        int[] nums = {1, 2, 2, 4};
        t.findErrorNums(nums);
    }
}
