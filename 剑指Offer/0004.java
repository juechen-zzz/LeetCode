/* 
输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。

示例1

输入
[1,2,3,4,5,6,7],[3,2,4,1,6,5,7]

返回值
{1,2,5,3,4,6,7}
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.HashMap;
public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        for (int i = 0; i < in.length; i++){
            map.put(in[i], i);
        }
        return helper(pre, 0, pre.length, in, 0, in.length);
    }
    
    public TreeNode helper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end){
        if (p_start == p_end) {return null;}

        int root_val = preorder[p_start];
        TreeNode root = new TreeNode(root_val);

        int i_root_index = map.get(root_val);
        int num = i_root_index - i_start;

        root.left = helper(preorder, p_start + 1, p_start + num + 1, inorder, i_start, i_root_index);
        root.right = helper(preorder, p_start + num + 1, p_end, inorder, i_root_index + 1, i_end);

        return root;
    }
}