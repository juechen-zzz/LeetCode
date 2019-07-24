"""
Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.
"""


class Solution:
    def trailingZeroes(self, n: int) -> int:
        num = 1
        for i in range(1,n+1):
            num = num * i
        ans = 0
        while num % 10 == 0:
            num = num // 10
            ans += 1
        return ans


class Solution:
    def trailingZeroes(self, n: int) -> int:
        f = 5
        pieces = int(n / f)
        result = 0
        while pieces >= 1:
            result += pieces
            f *= 5
            pieces = int(n / f)
        return result