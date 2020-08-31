/*******************************************************************************************
 * Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 * Input: matrix =[
 * [0,1,1,1],
 * [1,1,1,1],
 * [0,1,1,1]]
 * Output: 15
 * Explanation: 
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * there is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * 
 * *****************************************************************************************/
public class CountSquareSubmatriceswithAllOnes 
{
    public int countSquare(int[][] mat)
    {
        int result = 0;

        for(int i=0; i<mat.length; i++)
        {
            for(int j=0; j<mat[0].length; j++)
            {
                if(mat[i][j]>0 && i>0 && j>0){
                    mat[i][j] = Math.min(mat[i][j-1], Math.min(mat[i-1][j], mat[i][j])) +1;
                }
                
                result += mat[i][j];
            }
        }
        return result;
    }
}
//Time complexity = O(nxm)
//Space complexity = O(1);