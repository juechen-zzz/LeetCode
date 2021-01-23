/* 
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

 

示例 1：

输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

 */

class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int leftMax = 0, rightMax = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i]);
            rightMax = Math.max(rightMax, height[height.length - 1 - i]);
            ans += (leftMax + rightMax - height[i]);
        }
        return ans - leftMax * height.length;
    }
}