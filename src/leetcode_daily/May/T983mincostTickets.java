package leetcode_daily.May;

import java.util.Map;

/**
 * Author:cafe3165
 * Date:2020-05-25
 */
public class T983mincostTickets {
    public static int mincostTickets(int[] days, int[] costs) {
        int dayLen = days.length, maxDay = days[dayLen - 1], minDay = days[0];
        int[] dp = new int[maxDay+31];
        for (int d = maxDay, i = dayLen - 1; d >= minDay; d--) {
            if (d == days[i]) {
                dp[d] = Math.min(dp[d + 1] + costs[0], dp[d + 7] + costs[1]);
                dp[d] = Math.min(dp[d], dp[d + 30] + costs[2]);
                i--;
            } else {
                dp[d] = dp[d + 1];
            }
        }
        return dp[minDay];
    }

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20}, costs = {2, 7, 15};
        mincostTickets(days, costs);
    }
}
