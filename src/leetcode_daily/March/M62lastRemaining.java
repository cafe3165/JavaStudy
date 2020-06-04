package leetcode_daily.March;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-03-30
 */
public class M62lastRemaining {
    public int lastRemaining(int n, int m) {

        List<Integer> jos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            jos.add(i);
        }
        int index=0;
        while (n>1) {
            index=(index+m-1)%n;
            jos.remove(index);
            n--;

        }
        return jos.get(0);
    }

    public static void main(String[] args) {
        int n = 5, m = 3;
        M62lastRemaining M = new M62lastRemaining();
        M.lastRemaining(n, m);
    }
}
