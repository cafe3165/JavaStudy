package leetcode_daily.July;

public class M1713respace {
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

    public int respace(String[] dictionary, String sentence) {
        root = new TrieNode();
        for (int i = 0; i < dictionary.length; i++) {
            insert(dictionary[i]);
        }
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = n - i;
            TrieNode node = root;
            for (int j = i; j < n; j++) {
                int c = sentence.charAt(j) - 'a';
                if (node.next[c] == null) {
                    dp[i] = Math.min(dp[i], i - j + 1 + dp[j + 1]);
                    break;
                }
                if (node.next[c].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                } else {
                    dp[i] = Math.min(dp[i], i - j + 1 + dp[j + 1]);
                }
                node = node.next[c];

            }

        }

        return dp[0];
    }

    public static void main(String[] args) {
        M1713respace m = new M1713respace();
        String[] dictionary = {"looked", "just", "like", "her", "brother"};
        String sentence = "jesslookedjustliketimherbrother";
        m.respace(dictionary, sentence);

    }
}
