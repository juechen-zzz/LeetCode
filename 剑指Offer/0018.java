/* 
操作给定的二叉树，将其变换为源二叉树的镜像。
二叉树的镜像定义：源二叉树 
    	    8
    	   /  \
    	  6   10
    	 / \  / \
    	5  7 9 11
    	镜像二叉树
    	    8
    	   /  \
    	  10   6
    	 / \  / \
    	11 9 7  5
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
import java.util.Queue;
import java.util.LinkedList;
public class Solution {
    public void Mirror(TreeNode root) {
        if (root == null) {return;}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null || node.right != null) {
                TreeNode tmp = node.left;
                node.left = node.right;
                node.right = tmp;
            }
            if (node.left != null) {queue.offer(node.left);}
            if (node.right != null) {queue.offer(node.right);}
        }
    }
}