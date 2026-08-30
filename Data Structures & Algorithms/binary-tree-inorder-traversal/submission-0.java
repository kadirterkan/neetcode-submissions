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
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        return inOrderTraversal2(root, list);
    }

    List<Integer> inOrderTraversal2(TreeNode root, List<Integer> list) {
        if (root == null) {
            return list;
        }
        inOrderTraversal2(root.left, list);
        list.add(root.val);
        inOrderTraversal2(root.right, list);
        return list;
    }
}