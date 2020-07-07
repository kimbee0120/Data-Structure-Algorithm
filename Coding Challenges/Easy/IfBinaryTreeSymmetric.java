/**************************************************
Given a binary tree, test if it is symmetric both 
in value and in structure.
Input: 
       2
     /   \
    1     1

Output: true

Input: 
         4
       /   \
      2     2
     / \   /
    1   2 2

Output: false

Input: 
       X (empty tree)

Output: true

 *************************************************/
public class IfBinaryTreeSymmetric
{
    public boolean isSymmetric(TreeNode root)
    {
        //if it's empty tree, return true
        if(root == null)
            return true;

        //check if left and right is same
        return checkSymmetric(root.left, root.right);
    }

    boolean checkSymmetric(TreeNode leftroot, TreeNode rightroot)
    {
        //if both are null, return true
        if(leftroot == null && rightroot == null)
            return true;
        
        //check both are not null
        if(leftroot != null && rightroot != null )
        {
            boolean isSame = (leftroot.val == rightroot.val);
            boolean sideSame = checkSymmetric(leftroot.left, rightroot.right);
            boolean innerSame = checkSymmetric(leftroot.right, rightroot.left);

            return isSame&&sideSame&&innerSame; 
        }

        //else return false
        return false;
    }
}

//time comeplexity = O(n);
//space complexity = O(h);

