/* 
给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {return ans;}
        Queue<TreeNode> tmp = new LinkedList<>();
        tmp.offer(root);
        while (!tmp.isEmpty()) {
            int n = tmp.size();
            while (n > 0) {
                TreeNode node = tmp.poll();
                if (node.left != null) {tmp.add(node.left);}
                if (node.right != null) {tmp.add(node.right);}
                if (n == 1) {ans.add(node.val);}
                n--;
            }
        }
        return ans;
    }
}