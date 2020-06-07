package leetcode_daily.June;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-06-07
 */
public class T126findLadders {
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return res;
        }
        Map<String, Set<String>> successors = new HashMap<>();
        boolean found = bfs(beginWord, endWord, wordSet, successors);
        if (!found) {
            return res;
        }
        // 第 2 步：基于后继结点列表 successors ，使用回溯算法得到所有最短路径列表
        Deque<String> path = new ArrayDeque<>();
        path.addLast(beginWord);
        dfs(beginWord, endWord, successors, path, res);
        return res;
    }

    private static boolean bfs(String beginWord, String endWord, Set<String> wordSet, Map<String, Set<String>> successors) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        // 记录访问过的单词
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;
        int wordLen = beginWord.length();
// 当前层访问过的结点，当前层全部遍历完成以后，再添加到总的 visited 集合里
        Set<String> nextLevelVisited = new HashSet<>();

        while (!queue.isEmpty()) {
            int curSize = queue.size();
            for (int i = 0; i < curSize; i++) {
                String curWord = queue.poll();
                char[] chs = curWord.toCharArray();
                for (int j = 0; j < wordLen; j++) {
                    char oriChar = chs[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (chs[j] == k) {
                            continue;
                        }
                        chs[j] = k;
                        String nextWord = new String(chs);
                        if (wordSet.contains(nextWord)) {
                            if (!visited.contains(nextWord)) {
                                if (nextWord.equals(endWord)) {
                                    found = true;
                                }
                                nextLevelVisited.add(nextWord);
                                queue.offer(nextWord);
                                successors.computeIfAbsent(curWord, a -> new HashSet<>());
                                successors.get(curWord).add(nextWord);
                            }
                        }
                    }
                    chs[j] = oriChar;
                }
            }
            if (found) {
                break;
            }
            visited.addAll(nextLevelVisited);
            nextLevelVisited.clear();
        }
        return found;
    }

    private static void dfs(String beginWord, String endWord,
                            Map<String, Set<String>> successors,
                            Deque<String> path, List<List<String>> res) {
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (!successors.containsKey(beginWord)) {
            return;
        }

        Set<String> successorWords = successors.get(beginWord);
        for (String nextWord : successorWords) {
            path.addLast(nextWord);
            dfs(nextWord, endWord, successors, path, res);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        findLadders(beginWord, endWord, wordList);
    }
}
