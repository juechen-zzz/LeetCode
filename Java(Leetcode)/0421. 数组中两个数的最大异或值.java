/* 
给定一个非空数组，数组中元素为 a0, a1, a2, … , an-1，其中 0 ≤ ai < 231 。

找到 ai 和aj 最大的异或 (XOR) 运算结果，其中0 ≤ i,  j < n 。

你能在O(n)的时间解决这个问题吗？

示例:

输入: [3, 10, 5, 25, 2, 8]

输出: 28

解释: 最大的结果是 5 ^ 25 = 28.

 */

// https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/solution/shu-zu-zhong-liang-ge-shu-de-zui-da-yi-huo-zhi-by-/
class Solution {
    public int findMaximumXOR(int[] nums) {
        int maxNum = nums[0];
        for (int num : nums) {maxNum = Math.max(maxNum, num);}
        int n = (Integer.toBinaryString(maxNum)).length();

        int ans = 0, curXor;
        Set<Integer> prefixes = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            ans = ans << 1;
            curXor = ans | 1;
            prefixes.clear();

            for (int num : nums) {
                prefixes.add(num >> i);
            }
            for (int p : prefixes) {
                if (prefixes.contains(curXor ^ p)) {
                    ans = curXor;
                    break;
                }
            }
        }

        return ans;
    }
}