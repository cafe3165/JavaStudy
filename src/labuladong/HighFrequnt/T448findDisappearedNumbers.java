package labuladong.HighFrequnt;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-08-01
 */
public class T448findDisappearedNumbers {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if( nums[Math.abs(nums[i]) - 1]>0) {
                nums[Math.abs(nums[i]) - 1] *= -1;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                res.add(i+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        T448findDisappearedNumbers t = new T448findDisappearedNumbers();
        t.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1});

    }
}
