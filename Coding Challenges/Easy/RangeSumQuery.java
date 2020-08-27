/********************************************************************************************************
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * 
 * Example: Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 *******************************************************************************************************/
public class RangeSumQuery 
{
    int[] sums;
    public NumberArray(int[] nums){
        sums = new int[nums.length+1];

        for(int i=0; i<nums.length; i++){
            sums[i+1] = sums[i]+nums[i];
        }
    }   
    public int sumRange(int i, int j){
        return sums[j+1]-sums[i];
    }
}