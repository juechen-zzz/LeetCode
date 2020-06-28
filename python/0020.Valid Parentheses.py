'''
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true
'''

class Solution:
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        pre_dict = {')': '(', ']': '[', '}': '{'}
        stack = []
        for i in s:
            if i in pre_dict.values():  # 表明i为左括号，入栈
                stack.append(i)
        # i为右括号，若此时栈空(not stack)或者与出栈的不匹配则匹配出错 ，return False
            elif not stack or pre_dict[i] != stack.pop():
                return False
        return not stack  # 若结束时栈空则return True,反之return False
