package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-03-31
 */
public class bit {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        System.out.println(res);
    }
}
