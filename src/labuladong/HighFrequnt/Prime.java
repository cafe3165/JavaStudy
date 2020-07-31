package labuladong.HighFrequnt;

import java.util.Arrays;

/**
 * Author:cafe3165
 * Date:2020-03-30
 */
public class Prime {
    public static boolean[] eratos_prime(int n)// 埃拉托色尼 素数筛选法
    {
        boolean[] ans = new boolean[n ];
        Arrays.fill(ans, true);
        ans[0] = ans[1] = false;
        for (int i = 2; i * i <= n; i++) {
            if (ans[i]) {
                for (int j = i * i; j < n; j += i) {
                    ans[j]=false;
                }

            }
        }
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(eratos_prime(25));
    }

}
