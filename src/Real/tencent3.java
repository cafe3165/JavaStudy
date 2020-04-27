package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-26
 */
public class tencent3 {
    public static class card{
        public int a;
        public int b;

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        card[] cards=new card[n];
        for (int i = 0; i < n; i++) {
            cards[i]=new card();
            cards[i].a=sc.nextInt();
        }
        for (int i = 0; i <n; i++) {
           cards[i].b=sc.nextInt();
        }
        System.out.println(-1);
    }
}
