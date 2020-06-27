'''
罗马数字转阿拉伯数字
Example 1:

Input: "III"
Output: 3
Example 2:

Input: "IV"
Output: 4
Example 3:

Input: "IX"
Output: 9
Example 4:

Input: "LVIII"
Output: 58
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: "MCMXCIV"
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
'''

class Solution:
    def romanToInt(self, s):
        """
        :type s: str
        :rtype: int
        """
        num_list = []
        num = 0
        dit = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
        for i in range(len(s)-1):
            if dit[s[i]] < dit[s[i + 1]]:
                num = -dit[s[i]]
                num_list.append(int(num))
            else:
                num_list.append(int(dit[s[i]]))
        return sum(num_list) + dit[s[-1]]
