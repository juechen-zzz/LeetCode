/* 
给你一个整数数组 nums ，你可以对它进行一些操作。

每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。

开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。


示例 1：

输入：nums = [3,4,2]
输出：6
解释：
删除 4 获得 4 个点数，因此 3 也被删除。
之后，删除 2 获得 2 个点数。总共获得 6 个点数。
示例 2：

输入：nums = [2,2,3,3,3,4]
输出：9
解释：
删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
总共获得 9 个点数。

 */

// 类似于打家劫舍，先统计出相同数字一共有多少点数，然后就等价于打家劫舍里不能偷相邻两家
class Solution {
    public int deleteAndEarn(int[] nums) {
        int maxVal = 0;
        for (int n : nums) {maxVal = Math.max(maxVal, n);}

        int[] sum = new int[maxVal + 1];
        for (int n : nums) {sum[n] += n;}

        int first = sum[0], second = Math.max(sum[0], sum[1]);
        for (int i = 2; i < maxVal + 1; i++) {
            int tmp = second;
            second = Math.max(first + sum[i], second);
            first = tmp;
        }
        
        return second;
    }
}