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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();

        dfs(root, inorder);

        return inorder;
    }
     private void dfs(TreeNode currentNode, List<Integer> inorder) {
        if (currentNode == null) {
            return;
        }

        dfs(currentNode.left, inorder);

        inorder.add(currentNode.val);

        dfs(currentNode.right, inorder);
    }
}