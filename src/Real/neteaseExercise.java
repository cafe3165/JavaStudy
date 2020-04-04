package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-04
 */
public class neteaseExercise {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder sb=new StringBuilder();
       while(n!=0){
//           偶数
           if(n%2==0){
               sb.append("2");
               n=(n-2)/2;

           }else {
               sb.append("1");
               n=(n-1)/2;
           }

       }
        System.out.println(sb.reverse().toString());

    }
}
