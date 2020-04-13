package Real;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Author:cafe3165
 * Date:2020-04-10
 */
public class bianli1 {
    public static void solve(int[] Nums) {
        int[] dp = new int[Nums.length];
        dp[0] = Nums[0];
        int Max=Integer.MIN_VALUE;
        for (int i = 1; i < Nums.length; i++) {
            if (Nums[i] > dp[i - 1]+Nums[i]) {
                dp[i] = Nums[i];
            }else{
                dp[i]=dp[i-1]+Nums[i];
            }
        }
        for (int i = 0; i < dp.length; i++) {
            Max=Math.max(Max,dp[i]);
        }

        System.out.println(Max);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.next().split(",");
        int[] Nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Nums[i] = Integer.parseInt(nums[i]);
        }


        solve(Nums);
    }

}
