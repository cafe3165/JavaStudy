package leetcode_list200;

/**
 * Author:cafe3165
 * Date:2020-06-21
 */
public class T191numDecodings2 {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        int[] dp = new int[len];
        char[] chs = s.toCharArray();
        if (chs[0] == '0') {
            return 0;
        }
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (chs[i] != '0') {
                dp[i] = dp[i - 1];
            }
            int num = 10 * (chs[i - 1] - '0') + (chs[i] - '0');
            if (num >= 10 && num <= 26) {
                if (i == 1) {
                    dp[i]++;
                } else {
                    dp[i] += dp[i - 2];
                }
            }
        }
            return dp[len - 1];

    }

    public static void main(String[] args) {
        T191numDecodings2 t = new T191numDecodings2();
        String s = "2260023";
        System.out.println(t.numDecodings(s));
    }
}
