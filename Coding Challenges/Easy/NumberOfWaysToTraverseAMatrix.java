/******************************************************************
 * Given an integer value m (rows of a matrix), and an interger 
 * value n (columns of a matrix), return the total possible unique, 
 * simple, paths from the top-left of the matrix to the bottom-right 
 * with restricted moves.
 * You may only make one of these moves at each position:
 * Down 1 cell
 * Right 1 cell
 ******************************************************************/
public class NumberOfWaysToTraverseAMatrix {
    public int uniquePaths(int rows, int cols)
    {
        int[][] cellPath = new int[rows][cols];

        for(int i=0; i<rows; i++)//first stright col down
        {
            cellPath[i][0] = 1;
        }

        for(int i=0; i<cols; i++) //first row 
        {
            cellPath[0][i] = 1;
        }

        for(int i=1; i<rows; i++)
        {
            for(int j=1; j<cols; j++)
            {
                int upCell = cellPath[i-1][j];
                int leftCell = cellPath[i][j-1];

                cellPath[i][j] = upCell+leftCell;
            }
        }

        return cellPath[rows-1][cols-1];
    }
}

//Time complexity = O(nxm);