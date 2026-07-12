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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int currentLevel = 1;
        int answer = 1;
        int maxSum = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            int levelSum = 0;

            for (int i = 0; i < levelSize; i++) {

                TreeNode currentNode = queue.poll();

                levelSum += currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                answer = currentLevel;
            }

            currentLevel++;
        }

        return answer;
    }
}