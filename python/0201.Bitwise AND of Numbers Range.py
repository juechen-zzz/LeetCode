"""
Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

Example 1:

Input: [5,7]
Output: 4
Example 2:

Input: [0,1]
Output: 0

性质：n个连续数字求与的时候，前m位都是1.

举题目给的例子：[5,7] 共 5， 6，7三个数字， 用二进制表示 101, 110,111, 这三个数字特点是第一位都是1，后面几位求与一定是0
"""

class Solution:
    def rangeBitwiseAnd(self, m: int, n: int) -> int:
        while n > m:
            n &= n - 1      # 将二进制的n最后的1置为0
        return n