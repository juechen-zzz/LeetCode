/* 
给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。

示例 1:

输入: [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。

 */

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxDp = new int[n];
        int[] minDp = new int[n];
        maxDp[0] = nums[0];
        minDp[0] = nums[0];

        int ans = nums[0];
        for (int i = 1; i < n; i++) {
            maxDp[i] = Math.max(nums[i], Math.max(nums[i] * maxDp[i - 1], nums[i] * minDp[i - 1]));
            minDp[i] = Math.min(nums[i], Math.min(nums[i] * maxDp[i - 1], nums[i] * minDp[i - 1]));
            ans = Math.max(ans, maxDp[i]);
        }

        return ans;
    }
}