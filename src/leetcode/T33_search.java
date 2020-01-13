package leetcode;

public class T33_search {
    /**
     *@Author:cafe3165 on 2020/1/13 21:00
     *@Param:[nums, target]
     *@Return:int
     *@Description:查找
     */
    public int search(int[] nums, int target) {

         int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            // nums[0] <= nums[mid]（0 - mid不包含旋转）且nums[0] <= target <= nums[mid] 时 high 向前规约；
            if (nums[0] <= nums[mid]) {
                if (target <= nums[mid] && target >= nums[0]) {
                    high=mid;
                }
                else{
                    low=mid+1;
                }
            }else{
                //        nums[mid] < nums[0]（0 - mid包含旋转），target <= nums[mid] < nums[0] 时向前规约（target 在旋转位置到 mid 之间）
               if(target>=nums[0]||target<=nums[mid]){
                   high=mid;
               }else{
                   low=mid+1;
               }

            }


        }

        return low==high&&nums[low]==target?low:-1;

    }

    public static void main(String[] args) {
        T33_search t = new T33_search();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int[] nums2={5,1,3};
        int target = 5;
//       ;
        System.out.println( t.search(nums2, target));


    }
}
