import java.util.Queue;

import javax.swing.tree.TreeNode;

/********************************************************************************************
 * Binary Tree Level Order Traversal
 * 
 * Given a binary tree as input return its level order traversal.
 * A "level order traversal" is a level-by-level visitation of each node in the tree from 
 * top-to-bottom and left-to-right.
 * 
 * Input: 2
 *       / \
 *     3   4
 * 
 * Output:[
 * [2],
 * [3, 4]]
 * 
 * for depth-first search, we can use stack
 * for breadth-first search, we can use queue 
 *****************************************************************************************/
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> LevelOrderTraversal(TreeNode root)
    {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root); //or queue.offer(root)

        while(!queue.isEmpty())
        {
            List<Integer> layerList = new ArrayList<>();
            int layerSize = queue.size();

            for(int i=0; i<layerSize; i++)
            {
                TreeNode currNode = queue.poll();
                layerList.add(currNode.val);

                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
            }
            res.add(layerList);
        }
        return res;
    }
}