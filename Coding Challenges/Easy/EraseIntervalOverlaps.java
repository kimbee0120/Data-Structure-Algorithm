/*********************************************************************************************
 * Erase Interval Overlaps
 * 
 * Given a sequence of intervals return the minimum amount of intervals that need to be 
 * erased to eliminate all overlap conflicts.
 * 
 * Intervals i and j overlap if any of the following hold:
 * start(i) < start(j) and end(i) > start(j)
 * start(j) < start(i) and end(j) > start(i)
 * start(i) = start(j)
 * 
 * Input:[
 * [1, 2],
 *  [2, 3],
 * [3, 4],]
 * Output: 0
 * 
 * Explanation: No intervals removed, no overlaps.
 * 
 * Input:[
 * [1, 2],
 * [1, 2]]
 * Output: 1
 * Explanation: The minimum amount of intervals that need to be removed to make a non-overlapping 
 * set of intervals is 1, the [1, 2] interval.
 * 
 * given intervals are placed in random position (not sorted)
 * *************************************************************************************************/
public class EraseIntervalOverlaps
{
    public int eraseIntervalOverlaps(int[][] intervals)
    {
        Arrays.sort(intervals, (a,b)-> a[1]-b[1]); //ex) a[1]=2 and b[1]=3, 2-3= -1. negative value comes first. it will be ascending order

        int currEnd = intervals[0][1];
        int totalPossible = 1;

        for(int i=0; i<intervals.length; i++)
        {
            int[] curIntervals = intervals[i];
            int start = curIntervals[0];
            int end = curIntervals[1];

            if(start >= currEnd)
            {
                totalPossible++;
                currEnd = end;
            }
        }
        
        return (intervals.length - totalPossible);
    }
}
//Time complexity = O(n*logn) : comparison sorting is lower bounding nlogn 
//Space complexity = O(1)