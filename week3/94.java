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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        helper(root, res);
        return res;
    }
    
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        helper(root.left, res);
        res.add(root.val);
        helper(root.right, res);
    }

    // Solution 2: iterative
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pollFirst();
                res.add(node.val);
                cur = node.right;
            }
        }
        
        return res;
    }

    // Solution 3: Morris Traversal, use Threaded Binary Tree
    // can restore the tree
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        TreeNode cur = root;
        
        while (cur != null) {
            if (cur.left == null) {
                res.add(cur.val);
                cur =cur.right;
            } else {
                TreeNode left = cur.left;
                while (left.right != null && left.right != cur) {
                    left = left.right;
                }
                if (left.right == null) {
                    left.right = cur;
                    cur = cur.left;
                } else {
                    left.right = null;
                    res.add(cur.val);
                    cur = cur.right;
                }
            }
        }
        
        return res;
    }
    // Time = O(n)
    // Space = O(1)
}