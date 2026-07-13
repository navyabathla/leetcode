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
     private Map<Integer, Integer> inorderMap = new HashMap<>();

    private TreeNode constructTree(int[] preorder, int left, int right,
                                   int[] preorderIndex) {

        if (left > right) {
            return null;
        }

        int rootValue = preorder[preorderIndex[0]];
        preorderIndex[0]++;

        TreeNode root = new TreeNode(rootValue);

        int inorderIndex = inorderMap.get(rootValue);

        root.left = constructTree(preorder, left,
                                  inorderIndex - 1, preorderIndex);

        root.right = constructTree(preorder, inorderIndex + 1,
                                   right, preorderIndex);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        int[] preorderIndex = {0};

        return constructTree(preorder,
                             0,
                             inorder.length - 1,
                             preorderIndex);
    }
}