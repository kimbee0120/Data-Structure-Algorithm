/******************************************************************************************
 * House Robber
 * 
 * You are a professional robber planning to rob houses along a street. Each house has 
 * a certain amount of money stashed, the only constraint stopping you from robbing each 
 * of them is that adjacent houses have security system connected and it will automatically 
 * contact the police if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 ****************************************************************************************/

public class HouseRobber 
{
    public int houseRobber(int[] nums)
    {
        if(nums.length == 0 || nums == null){
            return 0;
        }

        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }
        return dp[nums.length-1];

        //time complexity = O(N);
        //space complexity = O(N);
    }    

    public int houseRobber2(int[] nums)
    {

        int pre = 0;
        int cur = 0;

        for(int n: nums)
        {
            int temp = pre;
            pre = Math.max(cur, pre);
            cur = n+temp;
        }

        return Math.max(pre, cur);

        //time complexity =O(N);
        //space complexity = O(1);
    }
}