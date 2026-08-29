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

    class Pair {
        TreeNode node;
        int depth;

        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    private Pair dfs(TreeNode root) {

        // Empty tree
        if (root == null) {
            return new Pair(null, 0);
        }

        // Find answer and depth in left subtree
        Pair left = dfs(root.left);

        // Find answer and depth in right subtree
        Pair right = dfs(root.right);

        // Left subtree has deeper leaves
        if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        }

        // Right subtree has deeper leaves
        if (right.depth > left.depth) {
            return new Pair(right.node, right.depth + 1);
        }

        // Both sides have deepest leaves at same depth
        // So current node is their LCA
        return new Pair(root, left.depth + 1);
    }
}