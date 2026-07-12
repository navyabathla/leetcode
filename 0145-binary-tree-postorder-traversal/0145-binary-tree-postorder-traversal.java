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
        List<Integer> postorder = new ArrayList<>();

        dfs(root, postorder);

        return postorder;
    }
    private void dfs(TreeNode currentNode, List<Integer> postorder) {
        if (currentNode == null) {
            return;
        }

        dfs(currentNode.left, postorder);
        dfs(currentNode.right, postorder);

        postorder.add(currentNode.val);
    }
}