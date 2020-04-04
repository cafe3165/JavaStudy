package Real;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-03-29
 */
public class du_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BigInteger[] a = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            a[i] =new BigInteger(String.valueOf(sc.nextInt())) ;
        }
        long k = 0;
        Arrays.sort(a);
        while (a[n - 1].intValue()>n) {
            a[n - 1] .subtract(new BigInteger(String.valueOf(n))) ;
            k++;
            for (int i = 0; i < n - 1; i++) {
                a[i].add(BigInteger.valueOf(1));
            }

            Arrays.sort(a);
        }
        System.out.println(k);
    }
}

