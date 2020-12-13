/*
根据一棵树的前序遍历与中序遍历构造二叉树。

注意:
你可以假设树中没有重复的元素。

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return helper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }

    public TreeNode helper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end){
        if (p_start == p_end) {return null;}

        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);

        int i_root_index = map.get(root_val);
        int num = i_root_index - i_start;

        root.left = helper(preorder, p_start+1, p_start+num+1, inorder, i_start, i_root_index);
        root.right = helper(preorder, p_start+num+1, p_end, inorder, i_root_index+1, i_end);

        return root;
    }
}