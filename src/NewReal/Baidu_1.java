package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-03
 */
public class Baidu_1 {
    public static int[] use;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        use=new int[n+1];
        for (int i = 1; i*9 <= n; i++) {
            use[i*9]=1;
        }
        Integer[] A=new Integer[n];
        int count5=0,count0=0;
        for (int i = 0; i < n; i++) {
            A[i]=sc.nextInt();
            if(A[i]==5){
                count5++;
            }else{
                count0++;
            }
        }
        if(count5==n){
            System.out.println(-1);
        }else{
            int num5=-1;
            for (int i = count5; i >=9 ; i--) {
                if(use[i]==1){
                    num5=i;
                    break;
                }
            }
            if(num5==-1){
                System.out.println(0);
            }else{
                for (int i = 0; i < num5; i++) {
                    System.out.print("5");
                }
                for (int i = 0; i < count0; i++) {
                    System.out.print("0");
                }
            }
        }
    }

}
