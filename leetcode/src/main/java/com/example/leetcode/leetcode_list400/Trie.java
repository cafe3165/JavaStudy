package com.example.leetcode.leetcode_list400;


import java.util.HashMap;
import java.util.concurrent.Executors;

public class Trie {

    class TrieNode {
        public boolean isEnd;
        public TrieNode[] next;

        TrieNode() {
            isEnd = false;
            next = new TrieNode[26];
        }
    }

    TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (null == word || "".equals(word)) {
            return;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (null == node.next[ch - 'a']) {
                node.next[ch - 'a'] = new TrieNode();
            }
            node = node.next[ch - 'a'];
        }
        node.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (null == word || "".equals(word)) {
            return false;
        }
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            node = node.next[ch - 'a'];
            if (null == node) {
                return false;
            }

        }
        return node.isEnd;
    }


    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (null == prefix || "".equals(prefix)) {
            return false;
        }
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            node = node.next[ch - 'a'];
            if (null == node) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) {
//            HashMap
//        Executors
        Executors.newCachedThreadPool();
    }


}
