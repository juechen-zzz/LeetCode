'''
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
'''

class Solution:
    def divide(self, dividend, divisor):
        """
        :type dividend: int
        :type divisor: int
        :rtype: int
        """
        result = 0
        temp = 0
        if divisor >= 0 and dividend >= 0 or divisor < 0 and dividend < 0:
            sign = 1
        else:
            sign = -1
        if dividend == 0 or divisor == 0:
            return 0
        dividend = abs(dividend)
        divisor = abs(divisor)

        for i in range(32, -1, -1):
            if temp + (divisor << i) <= dividend:
                temp += divisor << i
                result |= 1 << i

        if sign < 0:
            result = -result
        elif sign > 0:
            result = result

        if result < -2**31 or result > (2**31) -1:
            return 2**31 -1
        else:
            return result
