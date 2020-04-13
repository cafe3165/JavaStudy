package Real;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-02
 */
public class Meituan_3 {
    //    第一行一个数N，代表子弹数量。
//    第二行N个数p[]，第 i 个数代表p[i]。
//    第三行N个数a[]，第 i 个数代表a[i]。
//    1<=N<=5000   0<=p[i]<=1   0<=a[i]<=1000

    private static void solve(int n, double[] p, int[] a) {
        double res;
        double[] DP = new double[n], go = new double[n];
        DP[0] = p[0] * a[0];
        go[0] = p[0];
        for (int i = 1; i < n; i++) {
//            直接打i+1颗的期望
            double Max = p[i] * a[i];
            double gogo = p[i];
            for (int j = 0; j < i; j++) {
                if (DP[j] + (a[i - j - 1] * p[i - j - 1] * go[j]) > Max) {
                    Max = DP[j] + (a[i - j - 1] * p[i - j - 1] * go[j]);
                    gogo = p[i - j - 1] * go[j];
                }
            }
            DP[i] = Max;
            go[i] = gogo;
        }
        res = DP[n - 1];
//        System.out.println(String.format("%.2f", res));
        System.out.println(new DecimalFormat(".00").format(res));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] p = new double[N];
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = sc.nextDouble();
        }
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
//        3
//        0.9 0.1 0.1
//        2 1 1
        solve(N, p, a);

    }

}
