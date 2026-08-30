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
        if (root == null) {
            return true;
        }

        return balanced(root);
    }

    boolean balanced(TreeNode root) {
        if (root == null) return true;
        boolean lb = balanced(root.left);
        boolean rb = balanced(root.right);

        if (!lb || !rb) return false;

        int left = height(root.left);
        int right = height(root.right);

        return Math.abs(left - right) <= 1;
    }
 
    int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = height(root.left) + 1;
        int right = height(root.right) + 1;
        return left >= right ? left : right;
    }
}
