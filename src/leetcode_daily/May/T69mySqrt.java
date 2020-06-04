package leetcode_daily.May;

/**
 * Author:cafe3165
 * Date:2020-05-14
 */
public class T69mySqrt {
    public static int mySqrt(int x) {
        long l = 0, h = x/2+1;
        while (l < h) {
            long mid=(l+h+1)>>>1;
            long pow=mid*mid;
            if(pow>x){
                h=mid-1;
            }else{
                l=mid;
            }
        }
        return (int)l;


    }

    public static void main(String[] args) {
        int x = 9;
        System.out.println(mySqrt(x));

    }
}
