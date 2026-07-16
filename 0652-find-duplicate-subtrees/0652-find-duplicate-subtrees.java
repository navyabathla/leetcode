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
    private String dfs(TreeNode root, HashMap<String, Integer> map, List<TreeNode> result) {

        if (root == null)
            return "NULL";

        String serial = root.val + "," +
                        dfs(root.left, map, result) + "," +
                        dfs(root.right, map, result);

        if (map.getOrDefault(serial, 0) == 1)
            result.add(root);

        map.put(serial, map.getOrDefault(serial, 0) + 1);

        return serial;
    }
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        HashMap<String, Integer> map = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();

        dfs(root, map, result);

        return result;
    }
}