/**********************************************************
 * Given an array of n integers, return all unique triplets
 *  [a,b,c] in the array such that a + b + c = 0.
 * 
 * ex) 
 * Input: [-3, -1, 1, 0, 2, 10, -2, 8]
 * Output: 
 * [[-3, 1, 2],
 * [-2, 0, 2],
 * [-1, 0, 1]]
 **********************************************************/
public class TheThreeSum {
    public List<List<Integer>> threeSum(int[] arr)
    {
        Arrays.sort(arr); //sort array; if sum is bigger than 0, left increase or not, right increase
        Set<List<Integer>> set = new HashSet()<>; //create set to avoid duplicate 
        //check until arr.length-2 because max three number sum
        for(int i=0; i<arr.length-2; i++)
        {
            sums(i, arr, set)
        }

        return new ArrayList<>(set); //convert hashset to List
    }

    void sums(int i, int[] arr, Set<List<Integer>> set)
    {
        int leftcur = i+1;
        int rightcur = arr.length-1;

        while(leftcur<rightcur)
        {
            if(arr[i]+arr[leftcur]+arr[rightcur] == 0){
                set.add(Arrays.asList(arr[i], arr[leftcur], arr[rightcut]));
            }else if(arr[i]+arr[leftcur]+arr[rightcur] > 0){
                right--;
            }else{
                left++;
            }
        }
    }
}

//time complexity O(n^2)