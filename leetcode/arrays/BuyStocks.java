package arrays;

/**
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description
 */
public class BuyStocks {

    public static void main(String[] args) {
        new BuyStocks().maxProfit(new int[]{3,2,6,5,0,3});
    }

    /* Kadane's Algo - Dynamic Programming */
    public int maxProfit(int[] prices) {
        int curSum = 0, maxSum = 0;
        for(int i=1;i<prices.length;i++){
            curSum = Math.max(0,curSum+=prices[i]-prices[i-1]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }

    /* Own Approach - winner. Least time taken (3ms) */
    public int maxProfitMyApproach(int[] prices) {
        int profitMax = 0, max = -1;
        for(int j=prices.length-1;j>0;j--){
            if(prices[j]>max)
                max = prices[j];
            int profit = max - prices[j-1];
            if(profit > profitMax)
                profitMax = profit;
        }
        return profitMax;
    }

    public int maxProfitBruteForce(int[] prices) {
        int profitMax = 0;
        for(int i = 0;i<prices.length-1;i++){
            for(int j=i+1;j<prices.length;j++){
                if(prices[j]-prices[i]>profitMax){
                    profitMax = prices[j]-prices[i];
                }
            }
        }
        return profitMax;
    }
}
