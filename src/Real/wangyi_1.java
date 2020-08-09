package Real;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-08-08
 */
public class wangyi_1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long[] a=new long[n];
        int res=0;
        for (int i = 0; i < n; i++) {
            a[i]=sc.nextLong();
        }
        for (int i = 0; i < n; i++) {
            if(a[i]!=1){
                res+=a[i]/2;
            }
        }
        System.out.println(res);
    }


}
