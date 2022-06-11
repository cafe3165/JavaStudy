package com.example.leetcode.leetcode_daily.April;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-04-10
 */
public class T151reverseWords {
    public String reverseWords(String s) {
        List<String> sl = Arrays.asList(s.trim().split(" "));
        sl=new ArrayList<>(sl);
        sl.removeIf(tmp -> tmp.length() == 0);
        Collections.reverse(sl);
        return String.join(" ", sl);

    }

    public static void main(String[] args) {
        T151reverseWords t = new T151reverseWords();
        String s = "a good   example";
        t.reverseWords(s);


    }
}
