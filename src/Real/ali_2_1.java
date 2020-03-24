package Real;

import java.util.Scanner;
import java.util.regex.Matcher;

/**
 * Author:cafe3165
 * Date:2020-03-23
 */
public class ali_2_1 {

    //    public static long A(long m){
//
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long res = 0, fenmulast = 1, fenzilast = n;
        for (int i = 1; i <= n; i++) {
            fenmulast *= i;
            res += (i * fenzilast / fenmulast);
            fenzilast *= (n - i);

        }
        System.out.println();
        System.out.println(res);
//        Math.pow();

    }
}
