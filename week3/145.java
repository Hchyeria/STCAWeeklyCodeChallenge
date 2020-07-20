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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);
        TreeNode pre = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peekFirst();
            if (pre == null || pre.left == node || pre.right == node) {
                if (node.left != null) {
                    stack.offerFirst(node.left);
                } else if (node.right != null) {
                    stack.offerFirst(node.right);
                } else {
                    res.add(node.val);
                    stack.pollFirst();
                }
            } else if (pre == node.left) {
                if (node.right != null) {
                    stack.offerFirst(node.right);
                } else {
                    res.add(node.val);
                    stack.pollFirst();
                }
            } else {
                res.add(node.val);
                stack.pollFirst();
            }
            
            pre = node;
        }
        
        return res;
    }
}