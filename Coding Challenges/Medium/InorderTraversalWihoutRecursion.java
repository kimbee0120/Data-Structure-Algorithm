/***************************************************************
 * Inorder Traversal Without Recursion
 * 
 * Given a binary tree as input, return its inorder traversal.
 ***************************************************************/
public class InorderTraversalWithoutRecursion
{
    public List<Integer> Inorder(TreeNode root)
    {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null)
        {
            while(curr != null)
            {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            list.add(curr.val);

            curr = curr.right;
        }

        return list;
    }

}