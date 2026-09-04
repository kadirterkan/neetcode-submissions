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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelLength; i++) {
                TreeNode curr = queue.removeFirst();
                level.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            result.add(level);
        }
        return result;
    }
}
