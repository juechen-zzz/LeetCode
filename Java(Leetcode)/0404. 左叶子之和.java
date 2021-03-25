/*
计算给定二叉树的所有左叶子之和。

示例：

    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

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

// 1 dfs
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {return 0;}
        return dfs(root);
    }

    private int dfs(TreeNode root) {
        int ans = 0;
        if (root.left != null) {
            ans += (isLeaf(root.left) ? root.left.val : dfs(root.left));
        }
        if (root.right != null && !isLeaf(root.right)) {
            ans += dfs(root.right);
        }
        return ans;
    }

    private boolean isLeaf(TreeNode root) {
        return (root.left == null && root.right == null);
    }
}

// 2 bfs
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {return 0;}
        int ans = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int n = queue.size();
            for (int i = 0; i < n; i++){
                TreeNode node = queue.poll();
                if (node.left != null){
                    if (isLeafNode(node.left)) {ans += node.left.val;}
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node){
        if (node.left == null && node.right == null){return true;}
        else {return false;}
    }
}