package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-03-29
 */
public class du_1 {

    public static void solve(int n) {
        int max=Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <=n ; j++) {
                int g=gcd(i,j);
                int l=i*j/g;
                int num=l-g;
                if(num>max){
                    max=num;
                }
            }
            
        }
        System.out.println(max);

    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
//            如果传进来的 a<b在这一步的第一次递归则会倒转过来
            return gcd(b, a % b);
        }
    }

//    public static int lcm(int a, int b) {
//        return (a * b) / gcd(a, b);
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        solve(n);
    }


}
