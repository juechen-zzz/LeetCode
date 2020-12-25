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

// BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {return new LinkedList<>();}
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> tmp = new LinkedList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) {queue.offer(node.left);}
                if (node.right != null) {queue.offer(node.right);}
            }
            res.add(tmp);
        }
        return res;
    }
}