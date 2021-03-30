/* 
给定一个二叉树，它的每个结点都存放着一个整数值。

找出路径和等于给定数值的路径总数。

路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。

二叉树不超过1000个节点，且节点数值范围是 [-1000000,1000000] 的整数。

示例：

root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

返回 3。和等于 8 的路径有:

1.  5 -> 3
2.  5 -> 2 -> 1
3.  -3 -> 11

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
// 时间复杂度：每个节点只遍历一次,O(N)
// 空间复杂度：开辟了一个hashMap,O(N).
class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        return myMethod(root, prefixSumCount, sum, 0);
    }

    private int myMethod(TreeNode root, Map<Integer, Integer> prefixSumCount, int target, int curSum) {
        if (root == null) {return 0;}

        int ans = 0;
        curSum += root.val;

        //---核心代码
        // 看看root到当前节点这条路上是否存在节点前缀和加target为currSum的路径
        // 当前节点->root节点反推，有且仅有一条路径，如果此前有和为currSum-target,而当前的和又为currSum,两者的差就肯定为target了
        // currSum-target相当于找路径的起点，起点的sum+target=currSum，当前点到起点的距离就是target
        ans += prefixSumCount.getOrDefault(curSum - target, 0);
        prefixSumCount.put(curSum, prefixSumCount.getOrDefault(curSum, 0) + 1);

        ans += myMethod(root.left, prefixSumCount, target, curSum);
        ans += myMethod(root.right, prefixSumCount, target, curSum);

        prefixSumCount.put(curSum, prefixSumCount.get(curSum) - 1);
        return ans;
    }
}