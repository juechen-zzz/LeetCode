/* 
给定一个元素都是正整数的数组A ，正整数 L 以及 R (L <= R)。

求连续、非空且其中最大元素满足大于等于L 小于等于R的子数组个数。

例如 :
输入: 
A = [2, 1, 4, 3]
L = 2
R = 3
输出: 3
解释: 满足条件的子数组: [2], [2, 1], [3].

 */

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        // myMethod(x) 用于计算所有元素都小于等于 x 的子数组数量
        return myMethod(nums, right) - myMethod(nums, left - 1);
    }

    // 使用 cur 记录在 x 的左边，小于等于 x 的连续元素数量。
    // 当找到一个这样的元素时，在此位置上结束的有效子数组的数量为 cur + 1。
    // 当遇到一个元素大于 x 时，则在此位置结束的有效子数组的数量为 0。
    private int myMethod(int[] nums, int bound) {
        int ans = 0, cur = 0;
        for (int x : nums) {
            cur = (x <= bound ? cur + 1 : 0);
            ans += cur; 
        }
        return ans;
    }
}