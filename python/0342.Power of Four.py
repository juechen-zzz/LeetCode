"""
判断一个数是否为4的整数幂
"""

class Solution:
    def isPowerOfFour(self, n: int) -> bool:
        while n > 0 and n % 4 == 0:
            n = n / 4
        return True if n == 1 else False