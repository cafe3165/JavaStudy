package Real;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-16
 */
public class R360_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), a0 = sc.nextInt();
        double[][] dp = new double[n + 1][a0 + 1];
        dp[1][0] = 1;
        for (int i = 1; i <= a0; i++) {
            dp[1][i] = 1.0 / Double.parseDouble(String.valueOf(i + 1));
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= a0; j++) {
                double s = 0;
                for (int k = 0; k <= j; k++) {
                    s += dp[i - 1][k] * (1.0 / Double.parseDouble(String.valueOf(j + 1)));
                }
                dp[i][j]=s;
            }
        }
//        double res=new BigDecimal(dp[n][a0]).setScale(5,BigDecimal.ROUND_HALF_UP).doubleValue();
        double res=dp[n][a0];
        System.out.println(String.format("%.5f",res));


    }
}
