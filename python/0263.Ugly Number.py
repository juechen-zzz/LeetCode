"""
Write a program to check whether a given number is an ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.

Example 1:

Input: 6
Output: true
Explanation: 6 = 2 × 3
"""

# 任何一个丑叔都可以写成 n = 2^i * 3^j * 5^k
class Solution:
    def isUgly(self, num: int) -> bool:
        while num > 1 and (num % 2 == 0 or num % 3 == 0 or num % 5 == 0):
            if num % 2 == 0: num /= 2
            if num % 3 == 0: num /= 3
            if num % 5 == 0: num /= 5
        return num == 1
        
