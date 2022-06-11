package com.example.leetcode.leetcode_list200;

import java.util.HashSet;
import java.util.Set;

/**
 * Author:cafe3165
 * Date:2020-06-21
 */
public class T91numDecodings {
    private Set<String> set = new HashSet<>();

    public int numDecodings(String s) {
        backtrack(s, 0, "");
        return set.size();
    }

    private void backtrack(String s, int start, String path) {
        if (s.length() == start) {
            set.add(path);
            return;
        }
        int a = s.charAt(start) - '0';
        if (a <= 0 && start == s.length() - 1) {
            return;
        }
        if(a<=0){
            backtrack(s,start+1,path);
        }
        path += (char) (a + 64);
        backtrack(s, start + 1, path);
        path = path.substring(0, start);
        if (start == s.length() - 1) {
            return;
        }
        int tmp = Integer.parseInt(s.substring(start, start + 2));
        if (tmp >= 10 && tmp <= 26) {
            path += (char) (tmp + 64);
            backtrack(s, start + 2, path);
        }
    }

    public static void main(String[] args) {
        T91numDecodings t = new T91numDecodings();
        String s = "09";
        t.numDecodings(s);
//        char a = 2;
//        System.out.println((char) (a + 65));
    }
}
