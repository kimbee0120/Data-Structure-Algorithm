/******************************************************************
 * Given a two-dimensional square matrix (n x n), rotate the matrix
 *  90 degrees to the right (clockwise). 
 * 
 * ex)
 * input:
 * [[1,2,3,4],
 * [5,6,7,8],
 * [9,10,11,12],
 * [13,14,15,16]]
 * output:
 * [[13,9,5,1],
 * [14,10,6,2],
 * [15,11,7,3],
 * [16,12,8,4]]
 */
public class Rotating_2D_Matrix 
{
   public int[][] rotate(int[][] matrix)
   {
       int matSize = matrix.length-1;
        /************************************************************************
         * if matrix size is 4, we can rotate very first layer and second layer 
         * total 2 layer. 
         * if size is 5, rotate two outter layer and we have one middle index 
         * left which that we don't need to change or rotate.
         ***********************************************************************/
       for(int layer=0; layer<matrix.length/2; layer++)
       {
            for(int i=layer; i<(matSize-layer); i++)
            {
                int first = matrix[layer][i];
                int second = matrix[i][matSize-layer];
                int third = matrix[matSize-layer][matSize-i];
                int fourth = matrix[matSize-i][layer];

                matrix[layer][i] = fourth;
                matrix[i][matSize-layer] = first;
                matrix[matSize-layer][matSize-i] = second;
                matrix[matSize-i][layer] = third;
            }
       }

       return matrix;
   }
}

//space complexity  = constant 
//time complexity = mxn