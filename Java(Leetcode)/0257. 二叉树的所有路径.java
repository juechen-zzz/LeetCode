/* 
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3

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
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) {return ans;}
        dfs(root, "");
        return ans;
    }

    public void dfs(TreeNode root, String path) {
        if (root == null) {return;}
        
        StringBuilder sb = new StringBuilder(path);
        sb.append(Integer.toString(root.val));
        
        if (root.left == null && root.right == null) {
            ans.add(sb.toString());
        }
        else {
            sb.append("->");
            dfs(root.left, sb.toString());
            dfs(root.right, sb.toString());
        }
    }
}