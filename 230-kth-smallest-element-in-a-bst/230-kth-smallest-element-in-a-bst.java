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
    
    public ArrayList<Integer> helperInorder(TreeNode root, ArrayList<Integer> sorted) {
        if(root==null)
            return sorted;
        
        helperInorder(root.left, sorted);
        sorted.add(root.val);
        helperInorder(root.right, sorted);
        
        return sorted;

    }
    
    public int kthSmallest(TreeNode root, int k) {
        return helperInorder(root, new ArrayList<Integer>()).get(k-1);
    }
}