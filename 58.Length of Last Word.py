'''
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
'''

class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        if not s:
            return 0
        for i in range(len(s)-1, -1, -1):
            if s[i] != ' ':
                for j in range(i, -1, -1):
                    if s[j] == ' ':
                        return i - j
                    elif j == 0:
                        return i + 1
        return 0