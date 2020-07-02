'''
Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

Example 1:

Input: "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()"
Example 2:

Input: ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()"
'''

class Solution:
    def longestValidParentheses(self, s: str) -> int:
        dp = [0 for _ in range(len(s)+1)]
        for i in range(1, len(s)):
            if s[i] == ')' and i-dp[i-1]-1 >= 0 and s[i-dp[i-1]-1] == '(':
                dp[i] = dp[i-1] + 2
                if i-dp[i-1]-2 >= 0:
                    dp[i] += dp[i-dp[i-1]-2]
        return max(dp)

