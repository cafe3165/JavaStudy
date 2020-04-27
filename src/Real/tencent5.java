package Real;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-26
 */
public class tencent5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int Q=sc.nextInt();
        for (int i = 0; i < Q; i++) {
            long x=sc.nextLong();
            int k=sc.nextInt();
            List<Long> list=new ArrayList<>();
            while(x!=0){
                x>>=1;
                list.add(x);
            }
            if(list.size()-1<k){
                System.out.println(-1);
            }else{
                System.out.println(list.get(list.size()-k-1));
            }
        }


    }
}

// while(k>0){
//         if(x<=1){
//         break;
//         }
//         x>>=1;
//         k--;
//         }
//
//         if(k>0){
//         System.out.println(-1);
//         }else {
//         System.out.println(x);
//         }