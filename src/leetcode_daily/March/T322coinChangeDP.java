package leetcode_daily.March;

import java.util.Arrays;

/**
 * Author:cafe3165
 * Date:2020-03-08
 */
public class T322coinChangeDP {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;
//        for (int i = 1; i <= amount; i++) {
//            for (int j = 0; j < coins.length; j++) {
//                if(i-coins[j]>=0){
//                    dp[i] = Math.min(dp[i], dp[i - coins[j]]+1);
//                }
//            }
//        }
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i - coin >= 0) {
                    dp[i]=Math.min(dp[i], dp[i - coin]+1);
                }
            }
        }


        return dp[amount] > amount ? -1 : dp[amount];

    }

    public static void main(String[] args) {

        int[] coins = {1, 2, 5};
        int amount = 11;
        T322coinChangeDP t = new T322coinChangeDP();
        t.coinChange(coins, amount);

    }


}
