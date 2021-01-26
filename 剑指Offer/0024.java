/* 
输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */

import java.util.ArrayList;
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
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tmpPath = new ArrayList<>();
        if (root == null) {return ans;}
        dfs(ans, tmpPath, root, target, 0);
        return ans;
    }
 
    public void dfs(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> tmpPath, TreeNode root,int target, int sum) {
        if (sum + root.val == target && root.left == null && root.right == null) {
            tmpPath.add(root.val);
            ans.add(new ArrayList(tmpPath));
            return;
        }
        tmpPath.add(root.val);
        if (root.left != null) {
            dfs(ans, tmpPath, root.left, target, sum + root.val);
            tmpPath.remove(tmpPath.size() - 1);
        }
        if (root.right != null) {
            dfs(ans, tmpPath, root.right, target, sum + root.val);
            tmpPath.remove(tmpPath.size() - 1);
        }
    }
}