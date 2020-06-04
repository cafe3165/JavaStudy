package leetcode_daily.April;

/**
 * Author:cafe3165
 * Date:2020-04-06
 */
public class T72minDistance {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int change = dp[i - 1][j - 1] + 1;
                    int delete = dp[i - 1][j] + 1;
                    int add = dp[i][j - 1] + 1;
                    dp[i][j]=Math.min(change,Math.min(delete,add));
                }
            }
        }


        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {

        String word1 = "", word2 = "";
        T72minDistance t = new T72minDistance();
        t.minDistance(word1, word2);
    }
}
