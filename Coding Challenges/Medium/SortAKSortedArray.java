import java.util.PriorityQueue;

/**************************************************************************************************
 * Given a "k sorted array" return the fully sorted version of the sequence.
 * 
 * A "k sorted array" is a sequence whose elements are no more than k positions left or right from 
 * their position in the fully sorted sequence.
 * 
 * Input: k = 2, [3, 4, 1, 2, 5]
 * 
 * Distances from final sorted position:
 * 1: 2 positions right
 * 2: 2 positions right
 * 3: 2 positions left
 * 4: 2 positions left
 * 5: 0 positions away
 * Output: [1, 2, 3, 4, 5]
 ***************************************************************************************************/

public class SortAKSortedArray 
{
    public int[] sortAKSortedArray(int[] arr, int k)
    {
        PriorityQueue<Integer> minheap = new PriorityQueue<>();
        int[] res = new int[arr.length];

        //candidate insert upto <k
        for(int i=0; i<arr.length && i<k; i++)
        {
            minheap.add(arr[i]);
        }

        int cursor = k;
        int insertInd = 0;
        while(k<arr.length)
        {
            minheap.add(arr[k]);
            res[insertInd] = minheap.poll();

            cursor++;
            insertInd++;
        }

        while(!minheap.isEmpty())
        {
            res[insertInd] = minheap.poll();
            insertInd++;
        }

        return res;
    }
}