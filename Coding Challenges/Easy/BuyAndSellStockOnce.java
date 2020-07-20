/**************************************************************************************
 * We are given an array arr where the i'th element is the price for a stock on day i.
 * Determine the maximum profit that can be yielded by buying and selling a stock once.
 * 
 * Input: [1,2,3,4,5,6] Output: 5
 * Explanation: You buy on day 0 and sell on day 5 for a profit of 6 - 1 = 5.
 * 
 * Input: [12,4,6,9,3,8,4] Output: 5
 **************************************************************************************/
public class BuyAndSellStockOnce 
{
    public int maxProfit(int[] prices)
    {
        int minVal = prices[0]; //temp min value
        int maxProfit = 0; //temp max profit (it cannot be lower than 0)

        for(int i=1; i<prices.length; i++)
        {
            minVal = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i]-minVal);
        }

        return maxProfit;
        //Time complexity = O(n)
        //Space complexity = constant O(1)
    }

    public int maxProfitDynamic (int[] prices)
    {
        int[] profits = new int[prices.length];
        profits[0]=0;

        int max = 0;

        for(int i=1; i<prices.length; i++)
        {
            int difference = prices[i]-prices[i-1];
            int profit = profits[i-1]+difference;
            profits[i] = Math.max(0, profit);

            max = Math.max(max, profits[i]);
        }

        return max;
        //Time complexity = O(n)
    }
}