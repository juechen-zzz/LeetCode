"""
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

Example:

Input: n = 10
Output: 12
Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
"""

class Solution:
    def nthUglyNumber(self, n: int) -> int:
        dp = [1 for _ in range(n)]
        # 三指针初始化
        i2, i3, i5 = 0, 0, 0
        for i in range(1,n):
            min_val = min(dp[i2]*2,dp[i3]*3,dp[i5]*5)
            dp[i] = min_val
            # 找出哪个指针对应的数造出了现在这个最小值，将指针前移一位
            if dp[i2]*2 == min_val:
                i2 += 1
            if dp[i3]*3 == min_val:
                i3 += 1
            if dp[i5]*5 == min_val:
                i5 += 1
        return dp[-1]

