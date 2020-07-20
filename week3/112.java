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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        
        return helper(root, sum);
    }
    
    private boolean helper(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        target -= root.val;
        if (root.left == null && root.right == null) {
            if (target == 0) {
                return true;
            }
            return false;
        } else {
            return helper(root.left, target) || helper(root.right, target);
        }
    }
    // Time = O(2 ^ height)
    // Space = O(height)
}