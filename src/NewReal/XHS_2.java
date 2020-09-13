package NewReal;

import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-09-12
 */
public class XHS_2 {

    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int solution(String s) {
        dfs(s,0);
        return res;
    }
    static int res = Integer.MAX_VALUE;
    static void dfs(String s, int count) {

        if (s.length() == 0) {
            res = Math.min(res, count);
            return ;
        }
        int len = s.length();

        for (int i = 0; i < len; i++) {
            if (s.charAt(0) == s.charAt(i)) {
                String sub = s.substring(i + 1, len );
                dfs(sub, count + 1);
            }
        }

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        String _s = in.next();
        res = solution(_s);
        System.out.println(res);

    }
}
