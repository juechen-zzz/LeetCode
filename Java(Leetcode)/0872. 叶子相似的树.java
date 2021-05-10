/* 
请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。

举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。

如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。

如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。


示例 1：

输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
输出：true

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> nums1 = new ArrayList<>();
        if (root1 != null) {dfs(root1, nums1);}

        List<Integer> nums2 = new ArrayList<>();
        if (root2 != null) {dfs(root2, nums2);}

        return nums1.equals(nums2);
    }

    private void dfs(TreeNode node, List<Integer> nums) {
        if (node.left == null && node.right == null) {
            nums.add(node.val);
        }
        else {
            if (node.left != null) {dfs(node.left, nums);}
            if (node.right != null) {dfs(node.right, nums);}
        }
    }
}