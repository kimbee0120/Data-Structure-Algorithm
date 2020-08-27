public class MaximumSubarray 
{
    public int maxSub(int[] nums)
    {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for(int i=0; i<nums.length; i++)
        {
            if(sum<0){
                sum = nums[i];
            }else{
                sum += nums[i];
            }

            if(sum > max){
                max = sum;
            }
        }

        return max;
    }
    
    public int maxSubarray(int[] nums)
    {
        int max = nums[0];
        int sum = nums[0];

        for(int i=1; i<nums.length; i++)
        {
            sum = Math.max(sum+nums[i], nums[i]);

            max = Math.max(sum, max);
        }

        return max;
    }
}