/* 
编写一个程序，找出第 n 个丑数。

丑数就是质因数只包含 2, 3, 5 的正整数。

示例:

输入: n = 10
输出: 12
解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。

 */

class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        for (int i = 1; i < n; i++) {
            int minValue = Math.min(Math.min(dp[index2] * 2, dp[index3] * 3), dp[index5] * 5);
            dp[i] = minValue;
            if (dp[index2] * 2 == minValue) {index2++;}
            if (dp[index3] * 3 == minValue) {index3++;}
            if (dp[index5] * 5 == minValue) {index5++;}
        }
        return dp[n - 1];
    }
}