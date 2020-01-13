package leetcode;

/**
 * Author:cafe3165
 * Date:2020-01-13
 */
public class T34_searchRange {
    /**
     * @Author:cafe3165 on 2020/1/13 21:02
     * @Param:[nums, target]
     * @Return:int[]
     * @Description:变种的二分查找
     */
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int low = 0, high = nums.length - 1;
        while(low<high){
            int mid=(low+high)/2;
            if(target<=nums[mid]){
                high=mid;
            }else{
                low=mid+1;
            }
        }

        if(low==high&&nums[low]!=target){
            return new int[]{-1,-1};
        }else{

//            向前找

            while(low>=1&&nums[low]==nums[low-1]){
                low--;
            }
//            向后找
            while(high+1<nums.length&&nums[high]==nums[high+1]){
                high++;
            }

        }
        return new int[]{low,high};

    }

    public static void main(String[] args) {
        T34_searchRange t = new T34_searchRange();
//        int[] nums = {5, 7, 7, 8, 8, 10};
        int []nums={1};
        int target = 1;
        System.out.println(t.searchRange(nums, target));

    }
}
