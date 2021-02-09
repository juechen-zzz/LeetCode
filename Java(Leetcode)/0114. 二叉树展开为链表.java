/* 
给你二叉树的根结点 root ，请你将它展开为一个单链表：

展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
展开后的单链表应该与二叉树 先序遍历 顺序相同。
 

示例 1：


输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]

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
    List<TreeNode> ans = new ArrayList<>();

    public void flatten(TreeNode root) {
        helper(root);
        for (int i = 1; i < ans.size(); i++) {
            TreeNode prev = ans.get(i - 1), curr = ans.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void helper(TreeNode root) {
        if (root != null) {
            ans.add(root);
            helper(root.left);
            helper(root.right);
        }
    }
}