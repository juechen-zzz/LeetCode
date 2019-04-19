'''
LeetCode 7

Given a 32-bit signed integer, reverse digits of an integer.

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

def reverse(self, x):
    """
    :type x: int
    :rtype: int
    """
    a = abs(x)
    sum = 0
    while a > 0:
    	sum = sum * 10 + a % 10
    	a = a // 10
    pass
    sum = sum if x >=0 else -sum
    return sum if sum < 2**31 and sum > -2**31 else 0