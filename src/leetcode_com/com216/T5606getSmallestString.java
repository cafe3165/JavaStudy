package leetcode_com.com216;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class T5606getSmallestString {
    static List<List<Character>> res = new ArrayList<>();
    public static String getSmallestString(int n, int k) {
        LinkedList<Character> resList = new LinkedList<>();

        backtrack(n, k, resList);
        StringBuilder sb = new StringBuilder();
        for (Character c: res.get(0)) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }

    private static void backtrack(int n, int k, LinkedList<Character> tmp) {
        if (n == 0 && k == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 26; i > 0 && res.size() == 0; i--) {
            if (k >= i) {
                tmp.add((char) (96 + i));
                k -= i;
                backtrack(n - 1, k, tmp);
                k += i;
                tmp.pollLast();
            } else {
                i = k + 1;
            }
        }

    }

    public static void main(String[] args) {
        int n = 5, k = 73;
        System.out.println(getSmallestString(n, k));
    }
}
