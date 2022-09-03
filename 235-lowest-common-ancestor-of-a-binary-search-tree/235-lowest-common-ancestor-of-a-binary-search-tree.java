/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int curVal = root.val;
        
        if( p.val <= curVal && q.val <= curVal ) {
            if( p.val == curVal || q.val == curVal)
                return root;
            return lowestCommonAncestor(root.left, p, q);
        }
        
        if(p.val >= curVal && q.val >= curVal) {
            if( p.val == curVal || q.val == curVal)
                return root;
            
            return lowestCommonAncestor(root.right, p, q);
        }
        
        if( (p.val >= curVal && q.val <= curVal) || ( p.val <= curVal && q.val >= curVal ))
           return root;
           
        return root;
    }
}