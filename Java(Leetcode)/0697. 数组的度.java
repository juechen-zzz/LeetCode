/* 
给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。

你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。

示例 1：

输入：[1, 2, 2, 3, 1]
输出：2
解释：
输入数组的度是2，因为元素1和2的出现频数最大，均为2.
连续子数组里面拥有相同度的有如下所示:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组[2, 2]的长度为2，所以返回2.

 */

class Solution {
    public int findShortestSubArray(int[] nums) {
        // 用来存数组的度（字符出现的长度）
        Map<Integer, Integer> mapLen = new HashMap<>();
        // 用来存字符出现的最后位置
        Map<Integer, Integer> mapIndex = new HashMap<>();
        // 遍历数组给两个数组赋值
        int maxDegree = 0;
        for (int i = 0; i < nums.length; i++) {
            mapLen.put(nums[i], mapLen.getOrDefault(nums[i], 0) + 1);
            if (mapLen.get(nums[i]) > maxDegree) {maxDegree = mapLen.get(nums[i]);}
            mapIndex.put(nums[i], i);
        }
        // 第二次遍历数组 找出出现最多的数的长度
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (mapLen.get(nums[i]) == maxDegree) {
                ans = Math.min(ans, mapIndex.get(nums[i]) - i + 1);
                // 得出该字符的连续数组的长度以后修改一下字符出现的次数 不然可能会重新给res赋值
                mapLen.put(nums[i], -1);
            }
        }
        return ans;
    }
}