package leetcode_daily.June;

/**
 * Author:cafe3165
 * Date:2020-06-04
 */
public class T837new21Game {
    public static double new21Game(int N, int K, int W) {
        double[] dp = new double[K + W];
        double sum = 0.0;
        for (int i = K; i < K + W; i++) {
            dp[i] = i <= N ? 1.0 : 0.0;
            sum += dp[i];
        }
        for (int i = K - 1; i >= 0; i--) {
            dp[i] = sum / W;
            sum = sum - dp[i + W] + dp[i];
        }
        return dp[0];
    }

    public static void main(String[] args) {
        int N = 21, K = 17, W = 10;
        new21Game(N, K, W);


    }
}
