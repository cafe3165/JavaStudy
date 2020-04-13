package leetcode_daily;

import J2SE.ListTest;
import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-04-09
 */
public class M0807permutation {
    public static int l;
    public static String str;

    public String[] permutation(String S) {
        List<String> res = new ArrayList<>();
        str = S;
        l = S.length();
        boolean[] used = new boolean[l];
        dfs("", res, used);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(String s, List<String> res, boolean[] used) {
        if (s.length() == l) {
            res.add(s);
            return;
        }

        for (int i = 0; i < l; i++) {
            if (!used[i]) {
                s += str.charAt(i);
                used[i] = !used[i];
                dfs(s, res, used);
                used[i] = !used[i];
                s=s.substring(0,s.length()-1);
            }

        }

    }

    public static void main(String[] args) {
        M0807permutation m = new M0807permutation();
        String S = "qwe";
        m.permutation(S);
    }
}
