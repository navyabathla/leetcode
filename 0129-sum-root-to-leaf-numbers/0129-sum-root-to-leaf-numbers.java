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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode currentNode, int currentNumber) {

        if (currentNode == null) {
            return 0;
        }

        currentNumber = currentNumber * 10 + currentNode.val;

        if (currentNode.left == null && currentNode.right == null) {
            return currentNumber;
        }

        return dfs(currentNode.left, currentNumber)
             + dfs(currentNode.right, currentNumber);
    }

}