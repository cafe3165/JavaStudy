package Real;

import java.util.*;

/**
 * Author:cafe3165
 * Date:2020-04-29
 */
public class huawei1 {
    public static Set<String> res = new HashSet<>();

    public static int solve(String str) {
        char[] chs = str.toCharArray();
        dfs(0, chs);


        return res.size();
    }

    public static void dfs(int s, char[] chs) {
        if (s == chs.length - 1) {
            String str = Arrays.toString(chs);

            res.add(str);
        } else {
            for (int i = s; i < chs.length; i++) {
                swap(chs, s, i);
                dfs(s + 1, chs);
                swap(chs, s, i);
            }
        }


    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        if (str == null || str.length() == 0) {
            System.out.println(0);
        } else {
            System.out.println(solve(str));
        }


    }
}
