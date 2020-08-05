/***************************************************************
 * Clone A Graph
Given an undirected graph represented as an adjacency list, 
return a deep clone of the graph.
****************************************************************/

public class CloneAGraph {

    //BFS
    public GraphVertex cloneGraphBFS(GraphVertex start)
    {
        Map<GraphVertex, GraphVertex> map = new HashMap<>();
        Queue<GraphVertex> queue = new LinkedList<>();

        queue.offer(start);
        map.put(start, new GraphVertex(start.val));

        while(!queue.isEmpty())
        {
            GraphVertex curr = queue.poll();
            for(GraphVertex g: curr.adjacents)
            {
                if(!map.containsKey(curr)){
                    map.put(g, new GraphVertex(g.val));
                    queue.offer(g);
                }

                map.get(curr).adjacents.add(map.get(g));
            }
        }

        return map.get(start);
    }

    //DFS recursion
    HashMap<Integer, GraphVertex> map = new HashMap<>();
    public GraphVertex cloneGraphDFS(GraphVertex start)
    {
        return clonegraph(start);
    }
    public GraphVertex clonegraph(GraphVertex node)
    {
        if(node == null)
            return null;
        
        if(map.containsKey(node.val))
            return map.get(node.val);

        GraphVertex newNode = new GraphVertex(node);
        map.put(node.val, node);
        for(GraphVertex n: node.adjacents)
        {
            newNode.adjacents.add(clonegraph(n));
        }

        return newNode;
    }

    //DFS iterative
    public GraphVertex cloneGraphDFSI(GraphVertex start)
    {
        Map<GraphVertex, GraphVertex> map = new HashMap<>();
        Stack<GraphVertex> stack = new Stack<>();

        map.put(start, new GraphVertex(start.val));
        stack.push(start);

        while(!stack.isEmpty)
        {
            GraphVertex curr = stack.pop();

            for(GraphVertex g: curr.adjacents)
            {
                if(!map.containsKey(g))
                {
                    map.put(g, new GraphVertex(g.val));
                    stack.push(g);
                }

                map.get(curr).adjacents.add(map.get(g));
            }
        }
        return map.get(start);
    }


    
}