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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();

        dfs(root, targetSum, new ArrayList<>(), paths);

        return paths;
        
    }
    private void dfs(TreeNode currentNode, int remainingSum,
                     List<Integer> currentPath,
                     List<List<Integer>> paths) {

        if (currentNode == null) {
            return;
        }

        currentPath.add(currentNode.val);

        remainingSum -= currentNode.val;

        if (currentNode.left == null && currentNode.right == null
                && remainingSum == 0) {

            paths.add(new ArrayList<>(currentPath));
        }

        dfs(currentNode.left, remainingSum, currentPath, paths);
        dfs(currentNode.right, remainingSum, currentPath, paths);

        currentPath.remove(currentPath.size() - 1);
                     }
}