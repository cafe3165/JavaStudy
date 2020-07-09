package leetcode_list400;

public class T309maxProfit {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [][]dp=new int[n][2];

        for(int i=0;i<n;i++){
            if(i==0){
                dp[i][0]=0;
                dp[i][1]=-prices[i];
            }
            else if(i==1){
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            }
            else{
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-2][0]-prices[i]);
            }
        }
        return dp[n-1][0];
    }

    public static void main(String[] args) {
        T309maxProfit t=new T309maxProfit();
        int[] p={1,2,3,0,2};
        t.maxProfit(p);
    }
}
