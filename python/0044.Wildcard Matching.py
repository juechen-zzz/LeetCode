'''
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
'''
# 回溯
class Solution:
    def remove_duplicate_stars(self, p):
        if p == '': return p
        p1 = [p[0],]
        for x in p[1:]:
            if p1[-1] != '*' or (p1[-1] == '*' and x != '*'):
                p1.append(x)
        return ''.join(p1) 
        
    def helper(self, s, p):
        dp = self.dp
        if (s, p) in dp: return dp[(s, p)]

        if p == s or p == '*':
            dp[(s, p)] = True
        elif p == '' or s == '':
            dp[(s, p)] = False
        elif p[0] == s[0] or p[0] == '?':
            dp[(s, p)] = self.helper(s[1:], p[1:])
        elif p[0] == '*':
            dp[(s, p)] = self.helper(s, p[1:]) or self.helper(s[1:], p)
        else:
            dp[(s, p)] = False

        return dp[(s, p)]
        
    def isMatch(self, s, p):
        p = self.remove_duplicate_stars(p)
        self.dp = {}
        return self.helper(s, p)

# DP
class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        s = '0'+s
        p = '0'+p
        # dp[i][j]表示：s的前i个字符与p的前j个字符是否匹配
        dp = [[False for _ in range(len(p))] for _ in range(len(s))]

        # 初始化
        dp[0][0] = True  # 空字符串与空字符串相匹配
        for i in range(1, len(p)):
            dp[0][i] = dp[0][i-1] and p[i] == '*'
        for i in range(1, len(s)):
            dp[i][0] = False
        
        # 动态规划
        for i in range(1, len(s)):
            for j in range(1, len(p)):
                if s[i] == p[j] or p[j] == '?':
                    dp[i][j] = dp[i-1][j-1]
                elif p[j] == '*':
                    dp[i][j] = dp[i-1][j] or dp[i][j-1]
        return dp[-1][-1]
