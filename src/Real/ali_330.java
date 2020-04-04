package Real;

/**
 * Author:cafe3165
 * Date:2020-03-30
 */

import java.util.Scanner;
class ali330 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        long[] nums=new long[N];
        long sum=0;
        for (int i = 0; i < N; i++) {
            nums[i]=s.nextLong();

        }

        while(!isValid(nums)){
            long max=0;
            int index=0;
            for (int i = 0; i < nums.length; i++) {
                if(max<nums[i]){
                    max=nums[i];
                    index=i;
                }
            }
            sum+=max/N;
            for (int i = 0; i <N ; i++) {
                nums[i]+=max/N;
            }
            nums[index]=max%N;
        }
        System.out.println(sum);

    }
    public static boolean isValid(long[] nums){
        boolean res=true;
        for(long l:nums){
            if(l>=nums.length){
                res=false;
            }
        }
        return res;
    }
}