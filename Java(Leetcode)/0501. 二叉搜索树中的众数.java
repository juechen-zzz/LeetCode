/* 
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],

   1
    \
     2
    /
   2
返回[2].

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
    List<Integer> ans = new ArrayList<>();
    int count, maxCount, cur;

    public int[] findMode(TreeNode root) {
        inOrder(root);

        int[] tmp = new int[ans.size()];
        int idx = 0;
        for (int n : ans) {tmp[idx++] = n;}

        return tmp;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {return;}
        inOrder(root.left);
        myMethod(root.val);
        inOrder(root.right);
    }

    private void myMethod(int nodeVal) {
        if (cur == nodeVal) {count++;}
        else {
            count = 1;
            cur = nodeVal;
        }

        if (count == maxCount) {ans.add(cur);}

        if (count > maxCount) {
            ans.clear();
            maxCount = count;
            ans.add(cur);
        }
    }
}