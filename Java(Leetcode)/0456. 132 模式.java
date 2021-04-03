/* 
给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足：i < j < k 和 nums[i] < nums[k] < nums[j] 。

如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。

进阶：很容易想到时间复杂度为 O(n^2) 的解决方案，你可以设计一个时间复杂度为 O(n logn) 或 O(n) 的解决方案吗？

 

示例 1：

输入：nums = [1,2,3,4]
输出：false
解释：序列中不存在 132 模式的子序列。
示例 2：

输入：nums = [3,1,4,2]
输出：true
解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。

 */

class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int[] curMin = new int[n];
        curMin[0] = nums[0];

        for (int i = 1; i < n; i++) {curMin[i] = Math.min(curMin[i - 1], nums[i]);}
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= curMin[i]) {stack.pop();}
            if (!stack.isEmpty() && nums[i] > stack.peek()) {return true;}
            stack.push(nums[i]);
        }

        return false;
    }
}