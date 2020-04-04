package Real;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Author:cafe3165
 * Date:2020-04-01
 */
public class xiecheng_3 {
    public static int solve(String a, String b) {
        int l1 = a.length(), l2 = b.length();
        int[][] minedit = new int[l1][l2];
        for (int i = 0; i < l1; i++) {
            minedit[i][0] = i;
        }
        for (int j = 0; j < l2; j++) {
            minedit[0][j] = j;
        }
        for (int i = 1; i < l1; i++) {
            for (int j = 1; j < l2; j++) {
                minedit[i][j] = Integer.min(minedit[i - 1][j] + 1, minedit[i][j - 1] + 1);
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    minedit[i][j] = Integer.min(minedit[i][j], minedit[i - 1][j - 1]);
                } else {
                    minedit[i][j] = Integer.min(minedit[i][j], minedit[i - 1][j - 1] + 1);
                }
            }
        }
        return minedit[l1 - 1][l2 - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.next();
        String[] dic = {"surprise", "happy", "ctrip", "travel", "wellcome", "student", "system", "program", "editor"};
        int res = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < dic.length; i++) {
            int tmp = solve(str, dic[i]);
            if (res >= tmp) {
                res=tmp;
                index = i;
            }
        }
        if(res>2){
            System.out.println((char[]) null);
        }

        System.out.println(dic[index]);
    }
}
