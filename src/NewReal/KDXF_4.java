package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-12
 */
public class KDXF_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        long n = sc.nextLong();
        int len = s.length();
        n %= len;
        char[] chs = s.toCharArray();

        for (int i = 0; i < n; i++) {
            char tmp = chs[0];
            for (int j = 0; j < len-1; j++) {
                chs[j]=chs[j+1];
            }
            chs[chs.length-1]=tmp;
        }
//        reverse(chs, 0, n - 1);
//        reverse(chs, n, len - 1);
//        reverse(chs, 0, len - 1);
        String res = new String(chs);
        System.out.println(res);
    }

    public static void reverse(char[] chs, int start, int end) {
        while (start < end) {
            char tmp = chs[start];
            chs[start] = chs[end];
            chs[end] = tmp;
            start++;
            end--;
        }

    }
}
