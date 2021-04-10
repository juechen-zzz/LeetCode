/* 
给你一个二叉树的根结点，请你找出出现次数最多的子树元素和。一个结点的「子树元素和」定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。

你需要返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。

 

示例 1：
输入:

  5
 /  \
2   -3
返回 [2, -3, 4]，所有的值均只出现一次，以任意顺序返回所有值。

示例 2：
输入：

  5
 /  \
2   -5
返回 [2]，只有 2 出现两次，-5 只出现 1 次。

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
    Map<Integer, Integer> map = new HashMap<>();
    int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {return new int[0];}

        findSum(root);
        
        List<Integer> tmpList = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i) == maxCount) {
                tmpList.add(i);
            }
        }

        int[] ans = new int[tmpList.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = tmpList.get(i);
        }

        return ans;
    }

    private int findSum(TreeNode root) {
        if (root == null) {return 0;}

        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);
        int sum = root.val + leftSum + rightSum;

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxCount = Math.max(maxCount, map.get(sum));

        return sum;
    }
}