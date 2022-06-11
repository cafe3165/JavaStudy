package com.example.leetcode.leetcode_com.com216;

public class T5605arrayStringsAreEqual {
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s: word1) {
            sb1.append(s);
        }
        for (String s: word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        String[] word1 = {"ab", "c"}, word2 = {"a", "bc"};
        arrayStringsAreEqual(word1, word2);
    }
}
