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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();;
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        List<Integer> result = new ArrayList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            Object[] array = queue.toArray();
            result.add(((TreeNode) array[level-1]).val);
            for (int i = 0; i < level; i++) {
                TreeNode curr = queue.removeFirst();
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
        }
        return result;
    }
}
