package com.example.leetcode.leetcode_list200;

public class T5_longestPalindrome {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
//        我们观察到回文中心的两侧互为镜像。因此，回文可以从它的中心展开，并且只有 2n−1 个这样的中心。
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
//            回文串为奇数
            int len1 = expand(s, i, i);
//            回文串为偶数
            int len2 = expand(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
//                len-1是为了避免偶数长度/2以后大于i 如abba
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }

        }
        return s.substring(start, end + 1);


    }


    public int expand(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;

    }

    //    动态规划解法
    public String longestPalindrome2(String s) {

        int len = s.length();
        if (s.length() < 2) {
            return s;
        }

        boolean dp[][] = new boolean[len][len];
//        初始化
        for (int i = 0; i < len; i++) {
            dp[i][i]=true;
        }
        int start=0,maxLen=1;
        for (int j = 1; j < len; j++) {
            for (int i = 0; i <j ; i++) {
                if(s.charAt(i)==s.charAt(j)){
//                    中间只有一个或者两个字符
                    if(j-i<3){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=dp[i+1][j-1];
                    }
                }else{
                    dp[i][j]=false;
                }
                if(dp[i][j]){
                    int curLen=j-i+1;
                    if(curLen>maxLen){
                        start = i;
                        maxLen = curLen;
                    }
                }

            }
        }
        return s.substring(start,start + maxLen);


    }

    public static void main(String[] args) {
        T5_longestPalindrome t = new T5_longestPalindrome();


        System.out.println(t.longestPalindrome2("aabbaa"));
    }
}
