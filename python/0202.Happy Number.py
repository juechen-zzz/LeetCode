"""
Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

Example:

Input: 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
"""

class Solution:
    def isHappy(self, n: int) -> bool:
        visited = set()
        # 当 n != 1，并且没见过 n 时进行判断, 这个set用来做无限循环时的截止条件
        while n != 1 and n not in visited:
            visited.add(n)
            nxt = 0
            while n != 0:
                nxt += (n % 10) ** 2
                n //= 10
            n = nxt
        return n == 1
