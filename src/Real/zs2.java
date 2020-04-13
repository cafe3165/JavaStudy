package Real;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-08
 */
public class zs2 {
    public static int[] res;

    public static void solve(int t, Scanner sc) {
        for (int i = 0; i < t; i++) {
            String s = sc.next();
            int k = sc.nextInt();
            boolean f = true;
            while (s.length() != 0 && s.charAt(0) == '0') {
                s = s.substring(1);
                f = false;
            }
//            char[] tmp=s.toCharArray();
//            boolean f=false;
//            for (int j = 0; j < tmp.length; j++) {
//                if(tmp[j]='0')
//            }
            if (s.length() == 0 || s.length() < String.valueOf(k).length()) {
                System.out.println(0);
            }
//            System.out.println(s + " " + k);
            dfs(s, k, i, 0, 0, f);
            System.out.println(res[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        res = new int[t];
        solve(t, sc);
    }

    private static void dfs(String s, int k, int i, long pre, long cur, boolean f) {
        if (s.length() == 0) {
            if (pre + cur == k) {
                res[i]++;
            }
        } else {
            String ss = s.substring(1);
            long num = s.charAt(0) - '0';
            if (cur >= 0) {
                dfs(ss, k, i, pre, cur * 10 + num, false);

            }
            if (cur < 0) {
                dfs(ss, k, i, pre, cur * 10 - num, false);
            }
            if (!f) {
                dfs(ss, k, i, pre + cur, num, false);
                dfs(ss, k, i, pre + cur, -num, false);
            }
        }

    }
}
