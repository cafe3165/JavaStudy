package leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-05-28
 */
public class M51reversePairs {
    public static int reversePairs(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        return merge(nums, 0, nums.length - 1);
    }

    public static int merge(int[] nums, int start, int end) {
        if (start == end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int count = merge(nums, start, mid) + merge(nums, mid + 1, end);

        int[] tmp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            count += nums[i] <= nums[j] ? j - (mid + 1) : 0;
            tmp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            count += j - (mid + 1);
            tmp[k++] = nums[i++];
        }
        while (j <= end) {
            tmp[k++] = nums[j++];
        }

        System.arraycopy(tmp, 0, nums, start, end - start + 1);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {};

        System.out.println( reversePairs(nums));


    }
}
