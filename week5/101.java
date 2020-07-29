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

    // Solution 1: recursion
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        return helper(root.left, root.right);
    }
    
    private boolean helper(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        } else if (left == null || right == null) {
            return false;
        } else if (left.val != right.val) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    // Time = O(n)
    // Space = O(height)

    // explicitly use the stack
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root.left);
        stack.offerFirst(root.right);
        while (!stack.isEmpty()) {
            TreeNode right = stack.pollFirst();
            TreeNode left = stack.pollFirst();
            if (left != right) {
                if (left == null || right == null) {
                    return false;
                } else if (left.val != right.val) {
                    return false;
                }
            }
            if (left != null && right != null) {
                stack.offerFirst(left.left);
                stack.offerFirst(right.right);
                stack.offerFirst(left.right);
                stack.offerFirst(right.left);
            }
        }
        
        return true;
    }
}