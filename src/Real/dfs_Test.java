package Real;

import java.util.ArrayList;
import java.util.List;

/**
 * Author:cafe3165
 * Date:2020-03-20
 */
public class dfs_Test {
//    private static boolean[] f;

    List<Integer[]> res = new ArrayList<>();
    static boolean[] f = new boolean[1000];

    public static void solution(int n) {
        dfs(1, n);

    }

    public static void dfs(int cur, int n) {
//        到达终点状态
        if (cur == n) {

            return;

        }
//        越界或者不合法
//        if () {
//
//        }
//        剪枝
//        if () {
//
//        }

//        扩展状态

        for (int i = 0; i < n; i++) {
            if (!f[i]) {
                f[i] = true;


            }

        }


//


    }


    public static void main(String[] args) {

    }
}
