/* 
给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉搜索树:  root = [6,2,8,0,4,7,9,null,null,3,5]

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathForP = getPath(root, p);
        List<TreeNode> pathForQ = getPath(root, q);
        TreeNode ans = null;
        for (int i = 0; i < pathForP.size() && i < pathForQ.size(); i++) {
            if (pathForP.get(i) == pathForQ.get(i)) {
                ans = pathForP.get(i);
            }
            else {
                break;
            }
        }
        return ans;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        List<TreeNode> path = new ArrayList<>();
        TreeNode node = root;
        while (node != target) {
            path.add(node);
            if (target.val < node.val) {node = node.left;}
            else {node = node.right;}
        }
        path.add(node);
        return path;
    }
}
