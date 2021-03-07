/* 
输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */

public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {return true;}
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if (Math.abs(left - right) <= 1) {return true;}
        else {return false;}
    }
    
    public int TreeDepth(TreeNode root) {
        if (root == null) {return 0;}
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }
} 