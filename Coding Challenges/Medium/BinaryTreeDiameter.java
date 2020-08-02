/***********************************************************************************
 * Binary Tree Diameter
 * 
 * Given the root node to a binary tree, determine the longest path that exists 
 * between any two nodes in the tree.
 * 
 * Input: 1,  Output: 0
 * Explanation: Tree has a single node with no edges connecting it to another node. 
 * No longest node to node path can exist with only one node.
 * 
 * Input:
    1
   / \
  2   3
     /  \
    4    5
   /    / \
  6    7   8 
   \
    9

Output: 5
Explanation:
Longest Paths:
- [9,6,4,3,1,2]
- [9,6,4,3,5,7]
- [9,6,4,3,5,8]

Any one of these would be a valid longest path in the binary tree.  
The length of all these paths are 5.  
Notice that the root node is not guaranteed to be on the longest path in a binary tree.
 ******************************************************************************************/
public class BinaryTreeDiameter 
{
    public int diameterOfBinaryTree(TreeNode root)
    {
        recursiveNodeTree finalresult = getBestDiameter(root);

        return finalresult.bestDiameterSoFar;
    }

    public recursiveNodeTree getBestDiameter(TreeNode root)
    {
        if(root == null){
            return new recursiveNodeTree(0,0);
        }

        recursiveNodeTree left = getBestDiameter(root.left);
        recursiveNodeTree right = getBestDiameter(root.right);

        int preBestDiameter = Math.max(left.bestDiameterSoFar, right.bestDiameterSoFar);
        int maxDiameter = Math.max(left.height+right.heigh, preBestDiameter);
        int height = Math.max(left.height, right.height)+1;

        return new recursiveNodeTree(maxDiameter, height);
    }

    class recursiveNodeTree{
        int bestDiameterSoFar;
        int height;

        public recursiveNodeTree(int bestDiameterSoFar, int height)
        {
            this.bestDiameterSoFar = bestDiameterSoFar;
            this.height = height;
        }
    }
}