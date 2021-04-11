/* 
您需要在二叉树的每一行中找到最大的值。

示例：

输入: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

输出: [1, 3, 9]

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
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {return new ArrayList<Integer>();}
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            int n = queue.size();
            int curMax = Integer.MIN_VALUE;
            while (n > 0) {
                TreeNode node = queue.poll();
                curMax = Math.max(curMax, node.val);
                if (node.left != null) {queue.offer(node.left);}
                if (node.right != null) {queue.offer(node.right);}
                n--;
            }
            ans.add(curMax);
        }

        return ans;
    }
}