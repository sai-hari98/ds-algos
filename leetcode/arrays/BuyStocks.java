package arrays;

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

    /* Own Approach */
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
