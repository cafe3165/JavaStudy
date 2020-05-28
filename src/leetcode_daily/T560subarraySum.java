package leetcode_daily;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:cafe3165
 * Date:2020-05-16
 */
public class T560subarraySum {
    public static int subarraySum(int[] nums, int k) {
        int[] pre = new int[nums.length + 1];
        pre[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            pre[i + 1] = pre[i] + nums[i];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (pre[j + 1] - pre[i] == k) {
                    res++;
                }

            }
        }
        return res;

    }


    public static int subarraySum2(int[] nums, int k) {
        Map<Integer, Integer> PreMap = new HashMap<>();
        PreMap.put(0, 1);
        int preSum = 0, res = 0;
        for (int num : nums) {
            preSum += num;
            if (PreMap.containsKey(preSum - k)) {
                res += PreMap.get(preSum - k);
            }
            PreMap.put(preSum, PreMap.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,0,-2,-3,1};
        int k = 5;
        subarraySum2(nums, k);

    }
}
