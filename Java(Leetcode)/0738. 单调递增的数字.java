/* 
给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

示例 1:

输入: N = 10
输出: 9
示例 2:

输入: N = 1234
输出: 1234
示例 3:

输入: N = 332
输出: 299

 */

class Solution {
    public int monotoneIncreasingDigits(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        int idx = 1;
        while (idx < nums.length && nums[idx - 1] <= nums[idx]) {idx += 1;}

        if (idx < nums.length) {
            while (idx > 0 && nums[idx - 1] > nums[idx]) {
                nums[idx - 1] -= 1;
                idx -= 1;
            }
            idx += 1;
            while (idx < nums.length) {
                nums[idx] = '9';
                idx++;
            }
        }

        return Integer.parseInt(new String(nums));
    }
}