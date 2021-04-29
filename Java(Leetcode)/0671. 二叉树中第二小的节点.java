/* 
给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。

更正式地说，root.val = min(root.left.val, root.right.val) 总成立。

给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。

示例 1：
输入：root = [2,2,5,null,null,5,7]
输出：5
解释：最小的值是 2 ，第二小的值是 5 。

示例 2：
输入：root = [2,2,2]
输出：-1
解释：最小的值是 2, 但是不存在第二小的值。

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
class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {return -1;}     //没有最小节点

        //找出候选数，默认就是子节点值，如果子节点值和root值相同，递归，在子树中寻找候选数
        int left = root.left.val;
        int right = root.right.val;

        if (root.left.val == root.val) {left = findSecondMinimumValue(root.left);}
        if (root.right.val == root.val) {right = findSecondMinimumValue(root.right);}

        //如果左右候选数都正常，返回较小值就可
        if (left != -1 && right != -1) {return Math.min(left, right);}

        //如果候选数有-1，说明整个子树中没有可供候选的数
        if (left != -1){
            //左子树正常，答案就是左边的候选数
            return left;
        } 
        else {
            //右子树正常，返回答案
            //或者右子树也没有候选数，返回-1，即right
            return right;
        }
    }
}