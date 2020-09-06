package NewReal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-09-05
 */
public class sougou_12 {
    public int numberofprize(int a, int b, int c) {
        // write code here
        long res = 0;
       long[] nums=new long[3];
       nums[0]=a;
       nums[1]=b;
       nums[2]=c;
        Arrays.sort(nums);
        long t1=nums[1]-nums[0];
        long t2=nums[2]-nums[0];
        if(t2>=3*t1){
            res=(t2+2*t1)/5;
        }else{
           res=(t1+t2)/4;
        }


        return (int)(nums[0]+res);
    }
    public static void main(String[] args) {
        sougou_12 s=new sougou_12();

    }
}
