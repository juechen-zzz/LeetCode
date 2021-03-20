/* 
给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。

示例:

输入: 2
输出: 91 
解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。

 */

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        //个位为0，
        if(n == 0) {return 1;}
        int ans = 0;
        int[] dp = new int[n];
        dp[0] = 9;
        //分别计算 i位数 不包含0时对应的数量
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] * (9 - i);
        }
        //最终结果加上不包含0的情况
        for (int i = 0; i < n ; i++) {
            ans += dp[i];
        }
        //最终结果加上包含0的情况
        for (int i = 2; i <= n; i++) {
            ans += dp[i - 2] * (i - 1);
        }
        //加上0这种特殊情况
        return ans + 1;
    }
}
