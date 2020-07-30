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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        int m = preorder.length;
        int n = inorder.length;
        if (m != n) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            map.put(inorder[i], i);
        }
        
        return helper(preorder, 0, inorder, 0, n - 1, map);
    }
    
    private TreeNode helper(int[] preorder, int pl, int[] inorder, int il, int ir, Map<Integer, Integer> map) {
        if (il > ir) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pl]);
        if (il == ir) {
            return root;
        }
        int mid = map.get(preorder[pl]);
        int leftSize = mid - il;
        root.left = helper(preorder, pl + 1, inorder, il, mid - 1, map);
        root.right = helper(preorder, pl + 1 + leftSize, inorder, mid + 1, ir, map);
        return root;
    }

    // Time = O(n)
    // Space = O(n)
}