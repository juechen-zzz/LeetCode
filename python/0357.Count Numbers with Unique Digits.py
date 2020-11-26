"""
    给定一个数，计算0 ≤ x < 10^n 之间所有 不包含重复数字 的 数 的个数

Input: 2
Output: 91 
Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100, 
             excluding 11,22,33,44,55,66,77,88,99
"""
class Solution:
    def countNumbersWithUniqueDigits(self, n: int) -> int:
        dp = [0] * (n + 1)
        dp[0] = 1
        if n > 0:
            dp[1] = 9
            for i in range(2, n+1):
                dp[i] = dp[i-1] * (11 - i)
        return sum(dp)
        