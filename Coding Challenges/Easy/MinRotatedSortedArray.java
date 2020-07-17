/*********************************************************
 * Given a rotated sorted array, find the minimum element.
 * A "rotated" array is an array that has had each item 
 * shifted to the left or right by k units (where k is a 
 * positive integer) while maintaining positional integrity 
 * of every element in the original array.
 * 
 * ex)
 * Input: [4, 5, 6, 7, 1, 2] Output: 1
 * Input: [] Output: -1
 * Input: [55, 88, 91, 93, 2, 9, 20] Output: 2
 * 
 * Can you do this in O(log(n)) time?
 ************************************************************/

public class MinRotatedSortedArray 
{
    public int findMin1(int[] nums){
        Arrays.sort(nums);
        return nums[0];

        //O(n)
    }

    public int findMin2(int[] nums){
        if(nums.length<1) return -1;

        int left = 0;
        int right = nums.length-1;

        while(left<right)
        {
            int mid = left - ((right-left)/2); //  (left+right)/2 can causes integer ourbound and return negative num
            if(nums[mid]>nums[right]){
                left = mid+1;
            }else if(nums[mid]<nums[right]){
                right = mid;
            }
        }

        return nums[left];
    }

    //O(log(n))
}