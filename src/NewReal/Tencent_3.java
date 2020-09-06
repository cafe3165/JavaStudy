package NewReal;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-06
 */
public class Tencent_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] res = new int[n];
        int[] mids = getMids(nums);
        for (int i = 0; i < n; i++) {
            if(nums[i]<=mids[0]){
                res[i]=mids[1];
            }else{
                res[i]=mids[0];
            }
//            int[] newNums = getNums(nums, i);
//            res[i] = getMid(newNums);
        }
        //6 6 4 1 3 5 2
        for (int i = 0; i < n; i++) {
            System.out.println(res[i]);
        }
    }

    public static int[] getMids(int[] nums) {
        int[] mids = new int[2];
        int[] tmp=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            tmp[i]=nums[i];
        }

        Arrays.sort(tmp);
        mids[0]=tmp[nums.length/2-1];
        mids[1]=tmp[nums.length/2];
        return mids;
    }


    public static int[] getNums(int[] nums, int index) {
        int[] ans = new int[nums.length - 1];
        int newi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != index) {
                ans[newi++] = nums[i];
            }
        }
        return ans;
    }

    public static int getMid(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
