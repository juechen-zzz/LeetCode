/* 
输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
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
import java.util.*;
public class Solution {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if (root == null) {return ans;}
        dfs(root, target);
        return ans;
    }
    
    public void dfs(TreeNode root, int targetSum) {
        if (root == null) {return;}
        
        targetSum -= root.val;
        path.add(root.val);

        if (root.left == null && root.right == null && targetSum == 0) {ans.add(new ArrayList<>(path));}

        dfs(root.left, targetSum);
        dfs(root.right, targetSum);

        targetSum += root.val;
        path.remove(path.size() - 1);
    }
}