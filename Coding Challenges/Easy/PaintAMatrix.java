/**************************************************************************************
 * Paint A Matrix
 * 
 * Given a 2-color matrix and a point start, flip all points in the adjacent region of 
 * start to the opposite color.
 * 
 * Input:image = [
 * [0, 0, 1, 0],
 * [0, 0, 1, 0],
 * [0, 0, 1, 0],
 * [0, 0, 1, 0]]
 * row = 0
 * col = 1
 * newColor = 1
 * 
 * Output:[
 * [1, 1, 1, 0],
 * [1, 1, 1, 0],
 * [1, 1, 1, 0],
 * [1, 1, 1, 0],]
 * ***********************************************************************************/
public class PaintAMatrix {
    public int[][] paintMatrix(int[][] matrix, int row, int col, int newColor)
    {
        Queue<graph> queue = new LinkedList<>();
        Set<graph> visited = new HashSet<>();
        
        graph insertval = new graph(row,col);
        queue.offer(insertval);
        visited.add(insertval);

        while(!queue.isEmpty())
        {
            graph currval = queue.poll();
            matrix[currval.row][currval.col] = newColor;

            int[][] directions = {{0,-1}, {0,1}, {1,0}, {-1,0}};

            for(int[] dir: directions)
            {
                int newrow = currval.row+dir[0];
                int newcol = currval.col+dir[1];

                if(!isInBound(newrow, newcol, matrix)){
                    continue;
                }
                if(matrix[newrow][newcol] == newColor){
                    continue;
                }
                graph newinsert = new graph(newrow, newcol);
                if(!visited.contains(newinsert)){
                    visited.add(newinsert);
                    queue.offer(newinsert);
                }
            }
        }

        return matrix;
    }

    public boolean isInBound(int row, int col, int[][] matrix)
    {
        return (row>=0 && row<matrix.length && col>=0 && col<matrix[row].length);
    }

    public class graph
    {
        int row;
        int col;

        public graph(int row, int col)
        {
            this.row = row;
            this.col = col;
        }
    }
}