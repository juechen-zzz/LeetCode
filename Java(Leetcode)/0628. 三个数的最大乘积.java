/* 
给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

示例 1:

输入: [1,2,3]
输出: 6
示例 2:

输入: [1,2,3,4]
输出: 24

 */

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int temp1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int temp2 = nums[n - 1] * nums[0] * nums[1];
        return Math.max(temp1, temp2);
    }
}