package Real;


import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-10
 */
public class bianli2 {
    public static int solve(int[] Nums) {
        int last = 0, longest = 0, car = 0;
        for (int i = 0; i < Nums.length - 1; i++) {
            longest = Math.max(longest, Nums[i] + i);

            if (last == i) {
//                if(Nums[i]+i<=longest){
//                    return -1;
//                }

                last = longest;
                car++;
            }
        }
        if(longest<Nums.length-1){
            return -1;
        }

        return car;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nums = sc.next().split(",");
        int[] Nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            Nums[i] = Integer.parseInt(nums[i]);
        }

        System.out.println(solve(Nums));
    }
}
