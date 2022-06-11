package com.example.leetcode.leetcode_daily.March;

/**
 * Author:cafe3165
 * Date:2020-03-17
 */
public class T1160countCharacters {
    public int countCharacters(String[] words, String chars) {

        int[] chs = new int[26];
        int[][] wds = new int[words.length][26];
//        Arrays.fill(chs, 0);
//        Arrays.fill(wds, 0);
        for (int i = 0; i < words.length; i++) {
            char[] tmp = words[i].toCharArray();

            for (int j = 0; j < tmp.length; j++) {
                wds[i][tmp[j] - 'a']++;
            }

        }
        for (int i = 0; i < chars.length(); i++) {
            chs[chars.charAt(i) - 'a']++;
        }
        int res = 0;
        for (int i = 0; i < wds.length; i++) {

            boolean f = true;
            for (int j = 0; j < 26; j++) {
                if (wds[i][j] > chs[j]) {
                    f = false;
                    break;
                }
            }
            if (f) {
                res += words[i].length();
            }


        }

        return res;
    }

    public static void main(String[] args) {
        String[] words = {"cat", "bt", "hat", "tree"};
        String chars = "atach";
        T1160countCharacters t = new T1160countCharacters();
        t.countCharacters(words, chars);


    }
}
