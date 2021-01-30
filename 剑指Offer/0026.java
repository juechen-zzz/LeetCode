/* 
输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */

/**
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution {
    private TreeNode pre = null;
    
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {return null;}
        if (pRootOfTree.left == null && pRootOfTree.right == null) {return pRootOfTree;}
        
        helper(pRootOfTree);
        while (pRootOfTree.left != null) {
            pRootOfTree = pRootOfTree.left;
        }
        return pRootOfTree;
    }
    
    public void helper(TreeNode cur) {
        if (cur == null) {return;}
        if (cur.left != null) {helper(cur.left);}

        cur.left = pre;
        if (pre != null) {pre.right = cur;}
        pre = cur;
         
        if (cur.right != null) {helper(cur.right);}
    }
}