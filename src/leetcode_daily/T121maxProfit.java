package leetcode_daily;

/**
 * Author:cafe3165
 * Date:2020-03-09
 */
public class T121maxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxP = 0, minPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
            maxP = Math.max(maxP, prices[i] - minPrice);
        }
        return maxP;


    }

    public int maxProfit2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int maxP = 0, valley = prices[0], peak = prices[0];

        int i=0;
        while(i<prices.length-1){
            while(i<prices.length-1&&prices[i]>prices[i+1]){
                i++;
            }
            valley=prices[i];
            while(i<prices.length-1&&prices[i]<prices[i+1]){
                i++;
            }
            peak=prices[i];

            maxP+=peak-valley;





        }
        

        return maxP;
    }

    public static void main(String[] args) {
        T121maxProfit t = new T121maxProfit();
//        int[] prices = {7, 1, 5, 3, 6, 4};
        int[] prices={3,3};
        t.maxProfit2(prices);
    }
}
