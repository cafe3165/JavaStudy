package leetcode_list200;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-06-16
 */
public class T139wordBreak {
    private Set<String> wordSet = new HashSet<>();
    private Boolean[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        wordSet.addAll(wordDict);
        memo = new Boolean[s.length()];
        return solve(s, 0);
    }

    private boolean solve(String s, int start) {
        if (s.length() == start) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String tmp = s.substring(start, end);
            if (wordSet.contains(tmp) && solve(s, end)) {
                memo[start] = true;
                return memo[start];
            }
        }
        memo[start] = false;
        return memo[start];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        wordSet.addAll(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for (int i = 0; i <= len; i++) {
            for (int j = i + 1; j <= len; j++) {
                if (dp[i] && wordSet.contains(s.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = new ArrayList<>(Arrays.asList("leet", "code"));
        T139wordBreak t = new T139wordBreak();
        System.out.println(t.wordBreak2(s, wordDict));
    }
}
