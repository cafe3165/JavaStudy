package leetcode_daily.June;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Author:cafe3165
 * Date:2020-06-06
 */
public class T128longestConsecutive {
    public int longestConsecutive(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            numSet.add(nums[i]);
        }
        Iterator<Integer> it = numSet.iterator();
        int maxLen = Integer.MIN_VALUE;
        while (it.hasNext()) {
            int find = it.next() - 1;
            int count = 1;
            while (numSet.contains(find)) {
                count++;
                find--;
            }
            maxLen = maxLen < count ? count : maxLen;
        }
        return maxLen;

    }

    public static void main(String[] args) {
        T128longestConsecutive t = new T128longestConsecutive();
        int[] nums = {100, 4, 200, 1, 3, 2};
        t.longestConsecutive(nums);

    }
}
