/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    // A list to store the nodes' values in postorder sequence (left -> right -> root)
    private List<Integer> result = new ArrayList<Integer>();
    
    /**
     * Performs a postorder traversal on a binary tree starting from the given root.
     * Postorder traversal order: traverse left subtree, traverse right subtree, visit node.
     * 
     * @param root The root node of the binary tree.
     * @return A list containing the values of nodes in postorder traversal order.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        
        if (root == null)
            return result;
        
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        result.add(root.val);
        
        return result;
    }
}