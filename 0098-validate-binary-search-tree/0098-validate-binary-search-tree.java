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

    private TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode root) {

        if (root == null) {
            return true;
        }

        // 1. Check left subtree
        if (!inorder(root.left)) {
            return false;
        }

        // 2. Check current node
        if (prev != null && prev.val >= root.val) {
            return false;
        }

        // Current node becomes previous node
        prev = root;

        // 3. Check right subtree
        return inorder(root.right);
    }
}