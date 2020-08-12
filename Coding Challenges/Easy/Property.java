import java.util.Queue;

/***************************************************************************************
 * Given a binary tree, return whether is a valid binary search tree(BST) or not.
 * 
 * Valid BST is defined as:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 * 
 * Input:[2,1,4,NULL,NULL,3,5] 
 * Output: True
 * Explanation: 
 *    2
 *   / \
 *  1   4
 *     / \
 *   3   5  Valid BST.
 * 
 * 
 * Input:[5,2,7,NULL,NULL,3,12] 
 * Output: False
 * Explanation: 
 *   10
 *  / \
 * 2   7
 *    / \
 *   3   12 
 * 
 * ****************************************************************************************/
public class Property 
{
    public boolean isBSTRecursion(TreeNode root)
    {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private boolean checkBST(TreeNode node, int min, int max)
    {
        if(node == null){
            return true;
        }

        if(node.val <= min || max <= node.val){
            return false;
        }

        return (node.left, min, node.val) && (node.right, node.val, max);
    }

    public boolean isBSTBFS(TreeNode root)
    {
        Queue<minmaxNode> queue = new LinkedList<>();
        queue.offer(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        while(!queue.isEmpty())
        {
            minmaxNode current = queue.poll();
            if(current.node != null)
            {
                int currval = current.node.val;
                if(currval <= current.min || current.max <= currval)
                    return false;
            
                queue.offer(current.node.left, current.min, current.node.val);
                queue.offer(current.node.right, current.node.val, current.min);
            }
        }
        return true;
    }

    class minmaxNode{
        TreeNode node;
        int min;
        int max;

        public minmaxNode(TreeNode node, int min, int max)
        {
            this.node = node;
            this.min = min;
            this.max = max;
        }
    }
}