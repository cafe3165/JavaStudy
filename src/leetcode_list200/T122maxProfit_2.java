package leetcode_list200;

public class T122maxProfit_2 {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int [][]dp=new int[n][2];

        for(int i=0;i<n;i++){
            if(i==0){
                dp[i][0]=0;
                dp[i][1]=-prices[i];
            }else{
                dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
                dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            }
        }
        return dp[n-1][0];
    }
    public static void main(String[] args) {
        T122maxProfit_2 t=new T122maxProfit_2();
        int[] prices={1,2,3,4,5};
        t.maxProfit(prices);
    }
}
