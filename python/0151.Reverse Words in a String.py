'''
Given an input string, reverse the string word by word.

 

Example 1:

Input: "the sky is blue"
Output: "blue is sky the"
Example 2:

Input: "  hello world!  "
Output: "world! hello"
Explanation: Your reversed string should not contain leading or trailing spaces.
Example 3:

Input: "a good   example"
Output: "example good a"
Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 

Note:

A word is defined as a sequence of non-space characters.
Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
You need to reduce multiple spaces between two words to a single space in the reversed string.
'''


class Solution:
    def reverseWords(self, s: str) -> str:
        seq = s.split()[::-1]
        ans = ' '.join(seq)     # 返回通过指定字符连接序列中元素后生成的新字符串
        return ans

class Solution:
    def reverseWords(self, s: str) -> str:
        stack = []
        ans = ''
        for i in range(len(s)):
            if s[i] == ' ':
                stack.append(ans)
                ans = ''
            else:
                ans = ans + s[i]
        
        while stack:
            temp = stack.pop()
            if len(ans) > 0 and len(temp) > 0:
                ans = ans + ' ' + temp
            else:
                ans = ans + temp
        return ans
