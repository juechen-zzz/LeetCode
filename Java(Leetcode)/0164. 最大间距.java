/* 
给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。

如果数组元素个数小于 2，则返回 0。

示例 1:

输入: [3,6,9,1]
输出: 3
解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
示例 2:

输入: [10]
输出: 0
解释: 数组元素个数小于 2，因此返回 0。

 */

class Solution {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {return 0;}
        Arrays.sort(nums);
        int ans = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] > ans) {
                ans = nums[i] - nums[i - 1];
            }
        }
        return ans;
    }
}
