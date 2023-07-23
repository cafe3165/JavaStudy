package com.example.leetcode.jianzhi;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2023-03-05
 */
public class T38permutation {

    public  List<String> res = new ArrayList<>();
    public  boolean[] visited;

    private Set<String> set = new HashSet<>();

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return new String[]{};
        }
        char[] chs = s.toCharArray();
        List<Character> charList = new ArrayList<>(chs.length);
        for (char ch : chs) {
            charList.add(ch);
        }

        visited = new boolean[charList.size()];
        dfs(charList, "");
        return res.toArray(new String[0]);
    }

    private void dfs(List<Character> charList,  String curStr) {
        if (curStr.length() == charList.size() && !set.contains(curStr)) {
            res.add(curStr);
            set.add(curStr);
            return;
        }
        for (int i = 0; i < charList.size(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            dfs(charList, curStr + charList.get(i));
            visited[i] = false;
        }

    }




    public static void main(String[] args) {
        T38permutation t = new T38permutation();
        String[] r =  t.permutation("aab");
        for (String s : r) {
            System.out.println(s);
        }

    }
}
