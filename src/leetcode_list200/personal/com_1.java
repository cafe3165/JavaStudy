package leetcode_list200.personal;

/**
 * Author:cafe3165
 * Date:2020-04-18
 */
public class com_1 {
    public static int minCount(int[] coins) {
        int res = 0;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            int d = coin / 2;
            int s = coin % 2;
            res = res + d + s;

        }

        return res;
    }

    public static void main(String[] args) {
        int[] coins = {1};
        minCount(coins);

    }
}
