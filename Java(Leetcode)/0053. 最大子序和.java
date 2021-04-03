/* 
给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

 */

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 0) {return 0;}
        int[] dp = new int[n];
        int res = nums[0];

        dp[0] = nums[0];
        for (int i = 1; i < n; i++){
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}