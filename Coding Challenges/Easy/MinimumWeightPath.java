/*********************************************************************
 * Minimum Weight Path In A Triangle
 * 
 * Given a 2D array that resembles the shape of a triangle, return 
 * the min-cost path from the top to the bottom.
 * 
 * From each cell, you may only go diagonally down to the left or right.
 * 
 * Input:[
 * [5],
 * [1,6],
 * [4,3,10],
 * [3,2,4,1]]
 * 
 * Output: 11
 * Explanation:[
 *      [5],
 *    [1,  6],
 *  [4, 3, 10],
 * [3, 2, 4, 1]]
 ***********************************************************************************/

public class MinimumWeightPath 
{
    public int minimumWwightPathInATriangle(List<List<Integer>> triangle)
    {
        int totalsize = triangle.size();
        int[] cache = new int[totalsize];

        insertLastRow(cache, triangle.get(totalsize-1));

        for(int i=totalsize-2; i>=0; i--)
        {
            List<Integer> currlayer = triangle[i];

            for(int j=0; j<currlayer.size(); j++)
            {
                int currval = currlayer.get(j);
                int left = cache[j];
                int right = cache[j+1];

                int insert = Math.min(left+currval, right+currval);

                cache[j] = insert;
            }
        }
        return cache[0];
    }

    void insertLastRow(int[] cache, List<Integer> lastrow)
    {
        for(int i=0; i<lastrow.length; i++)
        {
            cache[i] = lastrow.get(i);
        }
    }
}