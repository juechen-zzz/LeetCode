'''
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
'''

class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        ans = []

        def backtrack(s = '', l = 0, r = 0):
            if len(s) == 2 * n:
                ans.append(s)
                return
            if l < n:
                backtrack(s+'(', l+1, r)
            if r < l:
                backtrack(s+')', l, r+1)
        
        backtrack()
        return ans