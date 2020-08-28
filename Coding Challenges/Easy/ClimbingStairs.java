/***************************************************************************************************
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Example 1:
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * Example 2:
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 ****************************************************************************************************/

public class ClimbingStairs 
{
        public int climbingstairs_BruteForce(int num)
        {
            if(num<=3){
                return num;
            }

            return checkstairs(num, 0);
        }

        public int checkstairs(int num, int total)
        {
            if(num==0){
                return 1;
            }

            if(num < 0){
                return 0;
            }

            total = checkstairs(num-1, total) + checkstairs(num-2, total);

            return total;
        }

        //Time complexity = O(2^n)
        

        public int climbingstairs_memoization(int num)
        {
            if(num<=3){
                return num;
            }
            int[] dp = new int[num+1];

            return checkstairs_memoization(num, dp);
        }

        int checkstairs_memoization(int num, int[] dp)
        {
            if(num==0){
                return 1;
            }

            if(num < 0){
                return 0;
            }

            if(dp[num] > 0){
                return dp[num];
            }

            dp[num] = checkstairs_memoization(num-1, dp) + checkstairs_memoization(num-2, dp);

            return dp[num];
        }
        //time complexity = O(N);
        //space complexity = O(N);

        public int climbingstairs_fibonacci(int num)
        {
            if(num<=3) return num;

            int f = 1;
            int s = 2;

            for(int i=3; i<=num; i++){
                int t = f+s;
                f = s;
                s = t;
            }

            return t;
        }
        //time complexity = O(n);
        //space complexity = O(1);
}   