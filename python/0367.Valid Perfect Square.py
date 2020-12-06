"""
    给定一个数，判断是否为平方数

Example 1:

Input: num = 16
Output: true
Example 2:

Input: num = 14
Output: false
"""

class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        value = num ** 0.5
        return value - int(value) == 0