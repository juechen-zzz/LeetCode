/* 
给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {return ans;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (n > 0) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {queue.offer(node.left);}
                if (node.right != null) {queue.offer(node.right);}
                n--;
            }
            ans.add(new ArrayList<>(tmp));
        }
        return ans;
    }
}