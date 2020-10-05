package newReal2;

/**
 * Author:cafe3165
 * Date:2020-09-28
 */
public class HW_2 {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2, N = prices.length;
        int[][] dp = new int[N + 1][2];
//       定义边界情况
        dp[0][0] = 0;
        dp[0][1] = -prices[0] - fee;
        for (int i = 1; i <= N; i++) {
//            当前不持有股票：从不持有转换成不持有；从持有转换成不持有，同时计算股票价格和手续费
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1] - fee);
//            当前持有股票
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
//        输出最后一天卖出股票的情况
        System.out.println(dp[N][0]);
    }
}
