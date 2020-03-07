package leetcode_list200.Com178;


import java.util.Arrays;

/**
 * Author:cafe3165
 * Date:2020-03-01
 */
public class smallerNumbersThanCurrentSolution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        if(nums.length==0){
            return new int[0];
        }
        int[] res =new int[nums.length];
        Arrays.sort(nums);
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if(i==0){
                res[i]=i;
                continue;
            }
            if(nums[i]==nums[i-1]){
                res[i]=i-1;
                count++;
            }
            res[i]=i-count;
        }
//        System.out.println(res);
    return res;
    }

    public int[] smallerNumbersThanCurrent2(int[] nums){
        int[] res =new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count=0;
            for (int j = 0; j <nums.length ; j++) {

                if(j!=i&&nums[j]<nums[i]){
                    count++;
                }
            }
            res[i]=count;
        }


//        System.out.println(res);
        return res;
    }
    public static void main(String[] args) {
        smallerNumbersThanCurrentSolution s=new smallerNumbersThanCurrentSolution();
        int[] nums={8,1,2,2,3};

        s.smallerNumbersThanCurrent2(nums);
    }
}
