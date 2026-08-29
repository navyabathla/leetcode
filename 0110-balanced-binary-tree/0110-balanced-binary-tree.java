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

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    private int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // Height of left subtree
        int left = height(root.left);

        // Left subtree is unbalanced
        if (left == -1) {
            return -1;
        }

        // Height of right subtree
        int right = height(root.right);

        // Right subtree is unbalanced
        if (right == -1) {
            return -1;
        }

        // Current node is unbalanced
        if (Math.abs(left - right) > 1) {
            return -1;
        }

        // Return height of current subtree
        return 1 + Math.max(left, right);
    }
}