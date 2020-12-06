"""
    给定a,b（a为整数，b为列表形式的一个数）
    求a ** b % 1337
"""

class Solution:
    def superPow(self, a: int, b: List[int]) -> int:
        K = 1337
        if len(b) == 1: return a**b[0] % K
        return ((self.superPow(a, b[:-1])) ** 10) * (self.superPow(a, [b[-1]])) % K