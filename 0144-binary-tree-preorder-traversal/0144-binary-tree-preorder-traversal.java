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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> preorder = new ArrayList<>();

        dfs(root, preorder);

        return preorder;
    }
     private void dfs(TreeNode currentNode, List<Integer> preorder) {
        if (currentNode == null) {
            return;
        }

        preorder.add(currentNode.val);

        dfs(currentNode.left, preorder);
        dfs(currentNode.right, preorder);
    }
}