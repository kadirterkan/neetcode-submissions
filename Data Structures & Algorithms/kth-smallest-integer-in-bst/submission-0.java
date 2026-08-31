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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = dfs(root, new ArrayList<>());
        return res.get(k-1);
    }

    List<Integer> dfs(TreeNode root, List<Integer> list) {
        if (root == null) return null;
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
        return list;
    }
}
