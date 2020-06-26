'''
数字反转

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
'''

class Solution:
    def reverse(self, x: int) -> int:
        temp = abs(x)
        ans = 0
        while temp > 0:
            ans = ans * 10 + temp % 10
            temp = temp // 10
        ans = ans if x >= 0 else -ans
        return ans if ans > -2**31 and ans < 2**31 else 0