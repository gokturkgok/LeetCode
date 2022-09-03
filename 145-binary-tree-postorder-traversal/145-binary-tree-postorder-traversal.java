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
    
    private void dfsPostOrder(TreeNode root, List<Integer> res){
        if(root == null)
            return;
        
        dfsPostOrder(root.left, res);
        dfsPostOrder(root.right, res);
        res.add(root.val);
    }
    
    
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfsPostOrder(root, res);
        return res;
    }
    
    
}