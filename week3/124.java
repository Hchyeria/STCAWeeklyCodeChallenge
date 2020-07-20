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
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] maxVal = { Integer.MIN_VALUE };
        helper(maxVal, root);
        return maxVal[0];
    }
    
    private int helper(int[] maxVal, TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = helper(maxVal, root.left);
        left = Math.max(left, 0);
        int right = helper(maxVal, root.right);
        right = Math.max(right, 0);
        int max = Math.max(left, right);
        maxVal[0] = Math.max(maxVal[0], left + right + root.val);
        return max + root.val;
    }

    // Time Complexity: O(n)
    // Space Complexity: O(height)
}