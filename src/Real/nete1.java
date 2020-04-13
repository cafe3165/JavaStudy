package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-07
 */
public class nete1 {
    public static void solve(int n, int[] a) {
        int[] del = new int[n - 1];
        int[] gc = new int[n - 2];
        int index1 = 0, index2 = 0;
        for (int i = 1; i < n; i++) {
            del[index1] = a[i] - a[i - 1];
            index1++;
        }
        long mingcd = Integer.MAX_VALUE - 1;
        for (int i = 1; i < n - 1; i++) {
            mingcd = Math.min(mingcd, gcd(del[i], del[i - 1]));
//            int tmp = gcd(del[i], del[i - 1]);
//            gc[index2] = tmp;
//            index2++;
        }


        System.out.println(mingcd > 0 ? mingcd : -1);
    }

    public static void solve2(int n, long[] a) {
        long[] del = new long[n - 1];
        int index1 = 0;
        for (int i = 1; i < n; i++) {
            del[index1] = a[i] - a[i - 1];
            index1++;
        }
        for (int i = 0; i < n - 2; i++) {
            gcd2(del[i], del[i + 1], del, i);
        }
        if (del[n - 2] > 0) {
            System.out.println(del[n - 2]);

        } else {
            System.out.println(-1);
        }

    }

    public static void gcd2(long x, long y, long[] arr, int i) {
        long tmp;
        if (x < y) {
            tmp = x;
            x = y;
            y = tmp;
            tmp = x % y;
            while (tmp != 0) {
                x = y;
                y = tmp;
                tmp = x % y;
            }
            arr[i + 1] = y;

        }


    }

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        } else {
//            如果传进来的 a<b在这一步的第一次递归则会倒转过来
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }


        solve2(n, a);
    }
}

