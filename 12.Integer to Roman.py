'''
oman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: 3
Output: "III"
Example 2:

Input: 4
Output: "IV"
Example 3:

Input: 9
Output: "IX"
Example 4:

Input: 58
Output: "LVIII"
Explanation: L = 50, V = 5, III = 3.
Example 5:

Input: 1994
Output: "MCMXCIV"
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
'''


class Solution:
    def intToRoman(self, num: int) -> str:
        s = ''
        if (num < 1 or num > 3999):
            return None
        if (num // 1000 != 0):
            s = s + (num // 1000) * 'M'
            num = num % 1000
        if (num // 100 == 9):
            s = s + 'CM'
            num = num - 900
        if (num // 500 != 0):
            s = s + (num // 500) * 'D'
            num = num % 500
        if (num // 100 == 4):
            s = s + 'CD'
            num = num - 400

        if (num // 100 != 0):
            s = s + (num // 100) * 'C'
            num = num % 100
        if (num // 10 == 9):
            s = s + 'XC'
            num = num - 90
        if (num // 50 != 0):
            s = s + (num // 50) * 'L'
            num = num % 50
        if (num // 10 == 4):
            s = s + 'XL'
            num = num - 40

        if (num // 10 != 0):
            s = s + (num // 10) * 'X'
            num = num % 10
        if (num // 1 == 9):
            s = s + 'IX'
            num = num - 9
        if (num // 5 != 0):
            s = s + (num // 5) * 'V'
            num = num % 5
        if (num // 1 == 4):
            s = s + 'IV'
            num = num - 4
        else:
            s = s + num * 'I'
        return s
