/* 
给定一个二进制数组， 计算其中最大连续1的个数。

示例 1:

输入: [1,1,0,1,1,1]
输出: 3
解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.

 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int n : nums) {
            if (n == 1) {count++;}
            else {
                ans = Math.max(ans, count);
                count = 0;
            }
        }
        ans = Math.max(ans, count);
        return ans;
    }
}