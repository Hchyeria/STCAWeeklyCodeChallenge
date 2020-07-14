/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: root of a tree
     * @return: head node of a doubly linked list
     */
     
    private TreeNode newHead;
    // Solution 1: recursion
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode[] pre = new TreeNode[1];
        helper(root, pre);
        newHead.left = pre[0];
        pre[0].right = newHead;
        return newHead;
    }
    
    private void helper(TreeNode root, TreeNode[] pre) {
        if (root == null) return;
        helper(root.left, pre);
        TreeNode node = new TreeNode(root.val);
        if (pre[0] != null) {
            pre[0].right = node;
            node.left = pre[0];
        } else {
            newHead = node;
        }
        pre[0] = node;
        
        helper(root.right, pre);
    }

    // Time = O(n)
    // Space = O(height)

    // Solution 2: iterative
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        TreeNode cur = root;
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null, newHead = null;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                if (pre != null) {
                    pre.right = cur;
                    cur.left = pre;
                } else {
                    newHead = cur;
                }
                pre = cur;
                cur = cur.right;
            }
        }
        pre.right = newHead;
        newHead.left = pre;
        
        return newHead;
    }

    // Time = O(n)
    // Space = O(n), no stack-overflow

    // Solution 3: Morris Traversal, use Threaded Binary Tree
    // can restore the tree
     public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        TreeNode cur = root;
        TreeNode pre = null, newHead = null;
        
        while (cur != null) {
            if (cur.left == null) {
                if (pre == null) {
                    newHead = cur;
                } else {
                    pre.right = cur;
                    cur.left = pre;
                }
                pre = cur;
                cur = cur.right;
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
                    pre.right = cur;
                    cur.left = pre;
                    pre = cur;
                    cur = cur.right;
                }
            }
        }
        
        pre.right = newHead;
        newHead.left = pre;
        
        
        return newHead;
    }
    // Time = O(n)
    // Space = O(1), no stack-overflow
}