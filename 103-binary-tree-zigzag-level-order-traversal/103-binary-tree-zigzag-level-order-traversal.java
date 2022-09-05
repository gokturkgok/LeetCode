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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root==null)
            return res;
        
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        boolean isReversed = false;
        
        while (queue.size() > 0) {
            ArrayList<Integer> level = new ArrayList<>();
            int n = queue.size();
            
            for (int i = 0; i < n ; i++) {
                TreeNode node = queue.pop();
                level.add(node.val);
                
                if(node.left!=null)
                    queue.add(node.left);
                if(node.right!=null)
                    queue.add(node.right);
            }
            
            if(isReversed)
                Collections.reverse(level);
            res.add(level);
            isReversed = !isReversed;
        }
        
        return res;
    }
}