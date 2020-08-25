/************************************************************************************************************
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).
 * 
 * Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the 
 * top of the floor, and you can either start from the step with index 0, or the step with index 1.
 * 
 * 
 * ex) Input: cost = [10, 15, 20] Output: 15
 * xplanation: Cheapest is start on cost[1], pay that cost and go to the top.
 * 
 * ex) Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1] Output: 6
 * Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 ***********************************************************************************************************/
public class MinCostClimbingStairs 
{
    public int minCostClimbingStairs1(int[] cost)
    {
        int num1 = cost[0];
        int num2 = cost[1];

        for(int i=2; i<=cost.length(); i++){
            int temp = ( i == cost.length? 0: cost[i]);
            temp = Math.min(temp+num1, temp+num2);

            num1 = num2;
            num2 = temp;
        }

        return Math.min(num1, num2);
    }    

    public int minCostClimbingStairs2(int[] cost)
    {
        int num1 = 0;
        int num2 = 0;

        for(int i=cost.length; i>=0; i--)
        {
            int temp = Math.min(cost[i]+num1, cost[i]+num2);
            
            num1 = num2;
            num2 = temp;
        }

        return Math.min(num1, num2);
    }
}