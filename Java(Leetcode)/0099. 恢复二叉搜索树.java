/*
给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。

进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？

示例 1：
输入：root = [1,3,null,null,2]
输出：[3,1,null,null,2]
解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
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
    public void recoverTree(TreeNode root) {
        List<Integer> nums = new ArrayList<Integer>();
        inorder(root, nums);
        int[] swapped = findTwoSwapped(nums);
        recoverTree(root, 2, swapped[0], swapped[1]);
    }

    public void inorder(TreeNode root, List<Integer> nums){
        if (root == null) {return;}
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public int[] findTwoSwapped(List<Integer> nums){
        int x = -1, y = -1;
        for (int i = 0; i < nums.size() - 1; i++){
            if (nums.get(i) > nums.get(i + 1)){
                y = nums.get(i + 1);
                if (x == -1) {x = nums.get(i);}
                else {break;}
            }
        }
        return new int[]{x, y};
    }

    public void recoverTree(TreeNode root, int count, int x, int y){
        if (root != null){
            if (root.val == x || root.val == y){
                root.val = (root.val == x) ? y : x;
                if (--count == 0){return;}
            }
            recoverTree(root.left, count, x, y);
            recoverTree(root.right, count, x, y);
        }
    }
}