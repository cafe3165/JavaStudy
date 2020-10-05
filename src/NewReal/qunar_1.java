package NewReal;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-23
 */
public class qunar_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        BigInteger mb = new BigInteger("1");
        BigInteger nb = new BigInteger("1");
        for (int i = m; i >= m - n + 1; i--) {
            mb = mb.multiply(new BigInteger(String.valueOf(i)));
        }
        for (int i = 1; i <= n; i++) {
            nb=nb.multiply(new BigInteger(String.valueOf(i)));
        }
        BigInteger res=mb.divide(nb);
        System.out.println(res.toString());
    }
}
