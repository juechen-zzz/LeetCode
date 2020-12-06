"""
    给定两个数（分别代表两个水瓶的容量），能否整出指定容量的水

Example 1: (From the famous "Die Hard" example)

Input: x = 3, y = 5, z = 4
Output: True
Example 2:

Input: x = 2, y = 6, z = 5
Output: False
"""

class Solution:
    def canMeasureWater(self, x: int, y: int, z: int) -> bool:
        if not z: return True       #edge case 
        
        def gcd(x, y): 
            """通过欧几里得算法返回最大公约数"""
            if x < y: x, y = y, x
            while y: 
                x, y = y, x % y
            return x
        
        return z <= x + y and z % gcd(x, y) == 0