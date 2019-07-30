"""
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0
"""

class Solution:
    def rangeBitwiseAnd(self, m: int, n: int) -> int:
        diff, power = (n - m), 0
        while (diff > 2 ** power):
            power += 1
        return m & n & (0xFFFFFFFF << power)