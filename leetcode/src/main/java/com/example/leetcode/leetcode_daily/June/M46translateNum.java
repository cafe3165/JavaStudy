package com.example.leetcode.leetcode_daily.June;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-06-12
 */
public class M46translateNum {
    public int translateNum(int num) {
        String s=String.valueOf(num);
        int a=1,b=1;
        // a:dp[i-1]  b:dp[i-2]
        for (int i = 2; i <=s.length(); i++) {
            String tmp=s.substring(i-2,i);
            int c=tmp.compareTo("10")>=0&&tmp.compareTo("25")<=0?a+b:a;
            b=a;
            a=c;
        }

        return a;
    }


    public static void main(String[] args) {
        M46translateNum m = new M46translateNum();
        m.translateNum(12258);
    }
}
