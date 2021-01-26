/* 
从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
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
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        if (root == null) {return new ArrayList<Integer>();}
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                ans.add(node.val);
                if (node.left != null) {queue.offer(node.left);}
                if (node.right != null) {queue.offer(node.right);}
            }
        }
        return ans;
    }
}