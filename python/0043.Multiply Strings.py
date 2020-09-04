'''
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"
Note:

The length of both num1 and num2 is < 110.
Both num1 and num2 contain only digits 0-9.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
'''

class Solution:
    def con2num(self, num):
        digit = 0
        for i in range(len(num)):
            # 以一个字符（长度为1的字符串）作为参数，返回对应的 ASCII 数值
            n = (ord(num[i]) - ord('0'))
            digits = digits * 10 + n
        return digit

    def multiply(self, num1: str, num2: str) -> str:
        return str(self.con2num(num1) * self.con2num(num2))