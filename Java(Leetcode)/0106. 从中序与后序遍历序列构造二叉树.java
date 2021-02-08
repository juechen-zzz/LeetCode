/* 
根据一棵树的中序遍历与后序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

中序遍历 inorder = [9,3,15,20,7]
后序遍历 postorder = [9,15,7,20,3]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

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
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }

    public TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (postStart == postEnd) {return null;}

        int rootVal = postorder[postEnd - 1];
        TreeNode root = new TreeNode(rootVal);

        int inRootIndex = map.get(rootVal);
        int leftNum = inRootIndex - inStart;

        root.left = helper(inorder, inStart, inRootIndex, postorder, postStart, postStart + leftNum);
        root.right = helper(inorder, inRootIndex + 1, inEnd, postorder, postStart + leftNum, postEnd - 1);

        return root;
    }
}