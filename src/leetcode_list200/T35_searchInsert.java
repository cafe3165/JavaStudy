package leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-01-13
 */
public class T35_searchInsert {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (target <= nums[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        if(nums[low]==target){
            return low;
        }else{
            return nums[low]>target?low:low+1;
        }

    }

    public static void main(String[] args) {

        T35_searchInsert t = new T35_searchInsert();
        int[] nums = {1, 3, 5, 6};
        int target = 2;

        System.out.println(t.searchInsert(nums, target));
    }
}
