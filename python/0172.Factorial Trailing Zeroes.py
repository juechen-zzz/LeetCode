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

# 实际就是在找5的倍数
# 返回 n//5 + n//25 + n//125 + n//(125×5) + n//(125×5×5) + ... 直到 n//(125×5×5×...) == 0

class Solution:
    def trailingZeroes(self, n: int) -> int:
        p = 0
        while n >= 5:
            n = n // 5
            p += n
        return p