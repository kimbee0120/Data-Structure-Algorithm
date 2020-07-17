/**************************************************
 * Given two sorted arrays, return a new array that
 *  represents their intersection. 
 * 
 * Input:[1,2,3,5],[1,2]  Output: [1,2]
 * Input:[1,2,2,3], [1,1,4] Output: [1]
 * 
 * It can solve as O(nxm) brute Force; check all 
 * elements
 * 
 * binary search O(min(n,m)*log(max(n,m)))
 * 
 * two pointer 
 ***************************************************/
public class TwoSortedArrays 
{
    public int[] intersection(int[] nums1, int[] nums2)
    {
        Set<Integer> res = new Hashset<>();

        int ptr1 = 0;
        int ptr2 = 0;

        while(ptr1 < nums1.length || ptr2<nums2.length)
        {
            if(nums1[ptr1]== nums2[ptr2]){
                res.add(nums1[ptr1]);
                ptr1++;
                ptr2++;
            }else if(nums1[ptr1] > nums2[ptr2]){
                ptr2++;
            }else{
                ptr1++;
            }
        }

        return setToArray(res);
    }
    

    int[] setToArray(Set<Integer> set)
    {
        int[] res = new int[set.size()];
        int i=0;
        for(int s:set){
            res[i]=s;
            i++;
        }

        return res;
    }
}


//time complexity = O(n);