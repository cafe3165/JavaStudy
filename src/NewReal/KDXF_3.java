package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-12
 */
public class KDXF_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int count=0;
        while(n>0){
            if((n&1)!=0){
                count++;
            }
            n>>=1;
        }
        System.out.println(count);
    }
}
