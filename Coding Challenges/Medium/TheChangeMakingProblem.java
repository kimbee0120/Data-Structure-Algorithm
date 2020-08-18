/************************************************************************************************************
 * The Change Making Problem
 * 
 * Given an array of integers that represent coins called coins and an integer amount amount, return the 
 * minimum amount of coins it requires to make complete change for amount amount.
 * 
 * If it is not possible to make change return -1.
 * 
 * Input: coins = [1, 2, 3], amount = 10
 * Output: 4
 * Explanation: We can use two 3 coins & two 2 coins to fully make change for 10. 3 + 3 + 2 + 2 = 10
 * 
 * Input: coins = [1, 3, 5, 6, 9], amount = 90
 * Output: 10
 * Explanation: 9 x 10 uses = 90
 * ***********************************************************************************************************/
public class TheChangeMakingProblem {
    public int leastCoinsTopbottom(int[] coins, int amount)
    {
        return checkCoin(coins, amount, new int[amount+1]);
    }
    private int checkCoin(int[] coins, int remainder, int[] dp)
    {
        if(remainder < 0)
            return -1;
        
        if(remainder == 0)
            return 0;
        
        if(dp[remainder] != 0)
            return dp[remainder];
        
        int min = Integer.MAX_VALUE;
        for(int coin:coins)
        {
            int coinvalue = checkCoin(coins, remainder-coin, dp);

            if(coinvalue <= 0 && coinvalue < min)
            {
                dp[remainder] = coinvalue +1;
            }
        }

        dp[remainder] = (min == Integer.MAX_VALUE) ? -1: min;

        return dp[remainder];
    }

    public int leastCoinsBottomTop(int[] coins, int amount)
    {
        int[] dp = new int[amount+1];

        Arrays.fill(dp, amount+1);
        dp[0] = 0;

        for(int i=1; i<=amount; i++)
        {
            for(int j=0; j<coins.length; j++)
            {
                if(coins[j]<= i){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1);
                }
            }
        }

        return dp[amount]>amount? -1: dp[amount];
    }

}