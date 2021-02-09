/* 
给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
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
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {return ans;}
        dfs(root, targetSum);
        return ans;
    }

    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {return;}
        
        targetSum -= root.val;
        path.add(root.val);

        if (root.left == null && root.right == null && targetSum == 0) {ans.add(new ArrayList<>(path));}

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

        targetSum += root.val;
        path.remove(path.size() - 1);
    }
}