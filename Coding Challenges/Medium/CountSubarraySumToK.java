/*************************************************************************
 * Given an array of integers arr and an integer value k, return the total
 * amount of unique, contiguous, subarrays that sum to k in arr.
 * 
 * Input: [1, 0, -1, 1] k = 0
 * Output: 4
 * Explanation: 4 subarrays sum up to 0
 *                i j
 * [1, 0, -1, 1] [1,1]
 * [1, 0, -1, 1] [0,2]
 * [1, 0, -1, 1] [1,3]
 * [1, 0, -1, 1] [2,3]
 *************************************************************************/
public class CountSubarraySumToK {
    public int countSubArray1(int[] arr, int k)
    {
        int[] sums = new int[arr.length];
        sums[0] = arr[0];

        for(int i=1; i<arr.length; i++)
        {
            sums[i] = sums[i-1]+arr[i];
        }

        for(int start = 0; start<sums.length; start++)
        {
            for(int end = start; end<sums.length; end++)
            {
                int tempsum = sums[end];
                if(start != 0){
                    tempsum+=sums[start-1];
                }

                if(tempsum == k) count++;
            }
        }
        return count;
    }
    //Time complexity = O(n^2)
    //Space Complexity = O(n) ;sums[]

    public int countSubArray2(int[] arr, int k)
    {
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0,1);

        int count = 0;
        int sum = 0;

        for(int a: arr)
        {
            sum += a;
            
            if(sums.containsKey(sum-k)){
                count+=sums.get(sum-k);
            }

            if(sums.containsKey(sum)){
                sums.put(sum, sums.get(sums)+1);
            }else{
                cums.put(sum, 1);
            }
        }

        return count;
    }
    //Time Complexity = O(n)
    //Space Complexity = O(n)

}