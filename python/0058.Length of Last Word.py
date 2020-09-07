'''
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Input: "Hello World"
Output: 5
'''
# split
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        sub_s = s.split(' ')
        while sub_s:
            if sub_s[-1] == '':
                sub_s.pop()
            else:
                return len(sub_s[-1])
        return 0

# tradition
class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        if len(s) == 0: return 0
        ans = []
        ind = 0
        for i in range(len(s)-1, -1, -1):
            if s[i] == ' ' and len(ans) == 0:
                continue
            elif s[i] == ' ':
                break
            else:
                ans.append(s[i])
        return len(ans)