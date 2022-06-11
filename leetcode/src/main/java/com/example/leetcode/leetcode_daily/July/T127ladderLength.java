package com.example.leetcode.leetcode_daily.July;

import java.util.*;

public class T127ladderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        wordList.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        queue.add(beginWord);
        vis.add(beginWord);
        int wordLen = beginWord.length();
        int step = 0;

        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                String curword = queue.poll();
                char[] chs = curword.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char orginChar = chs[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == orginChar) {
                            continue;
                        }
                        chs[j] = k;
                        String nextWord = String.valueOf(chs);
                        if (wordSet.contains(nextWord)) {
                            if (nextWord.equals(endWord)) {
                                return step + 1;
                            }
                            if (!vis.contains(nextWord)) {
                                queue.add(nextWord);
                                vis.add(nextWord);
                            }
                        }
                    }
                    chs[j] = orginChar;
                }
            }
            step++;
        }
        return 0;

    }

    public static void main(String[] args) {
        T127ladderLength t = new T127ladderLength();
        String beginWord = "hit", endWord = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(words);
        System.out.println(t.ladderLength(beginWord, endWord, wordList));
    }

}
