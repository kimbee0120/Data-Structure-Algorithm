/*********************************************************************
 * Check If A Graph Is Bipartite
 * 
 * Given a graph return true if it is bipartite, return false otherwise.
 * 
 * Input:[
 * [3],
 * [3],
 * [4],
 * [],
 * [],]
 * Output: true
 * 
 * Index 0 = 3, index 1=3, index 2=4 ...so on
 * 
 * ******************************************************************/

 //use BFS 
public class CheckIfAGraphIsBipartite {
    public boolean checkIfAGraphIsBipartite(int[][] graph)
    {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        int[] color = new Int[graph.length];

        for(int i=0; i<graph.length; i++)
        {
            if(!visited.contains(i))
            {
                visited.add(i);
                color[i]=1;
                queue.offer(i);

                while(!queue.isEmpty())
                {
                    int currval = queue.poll();
                    for(int g: graph[currval])
                    {
                        visited.add(g);
                        if(color[g] == 0){
                            color[g] = -color[currval];
                            queue.offer(g);
                        }else if(color[g] != -color[curval]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}