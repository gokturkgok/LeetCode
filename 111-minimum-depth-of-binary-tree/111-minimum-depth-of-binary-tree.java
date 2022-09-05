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
    public int minDepth(TreeNode root) {
        
        if(root==null)
            return 0;
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        
        int depth = 0;
        
        queue.add(root);
        
        while(queue.size()>0) {
            depth++;
            int n = queue.size();
            for(int i = 0; i < n; i++) {
                TreeNode node = queue.pop();
                
                if(node.left==null && node.right==null)
                    return depth; // early return
                
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
        }
        
        return depth;
    }
}