/* 
给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。

示例 1：

输入：root = [3,1,4,null,2], k = 1
输出：1

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
    List<Integer> ans = new ArrayList<>();

    public int kthSmallest(TreeNode root, int k) {
        helper(root);
        return ans.get(k - 1);
    }

    public void helper(TreeNode root) {
        if (root == null) {return;}
        helper(root.left);
        ans.add(root.val);
        helper(root.right);
    }
}