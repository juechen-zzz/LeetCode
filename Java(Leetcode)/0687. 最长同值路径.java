/* 
给定一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。

注意：两个节点之间的路径长度由它们之间的边数表示。

示例 1:
输入:

              5
             / \
            4   5
           / \   \
          1   1   5
输出:

2

示例 2:
输入:

              1
             / \
            4   5
           / \   \
          4   4   5
输出:
2

 */

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
    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        myMethod(root);
        return ans;
    }

    public int myMethod(TreeNode node) {
        if (node == null) {return 0;}
        int left = myMethod(node.left);
        int right = myMethod(node.right);

        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {arrowLeft += left + 1;}
        if (node.right != null && node.right.val == node.val) {arrowRight += right + 1;}
        
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}