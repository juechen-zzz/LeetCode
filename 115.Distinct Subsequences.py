'''
Given a string S and a string T, count the number of distinct subsequences of S which equals T.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Example 1:

Input: S = "rabbbit", T = "rabbit"
Output: 3
Explanation:

As shown below, there are 3 ways you can generate "rabbit" from S.
(The caret symbol ^ means the chosen letters)

rabbbit
^^^^ ^^
rabbbit
^^ ^^^^
rabbbit
^^^ ^^^
Example 2:

Input: S = "babgbag", T = "bag"
Output: 5
Explanation:

As shown below, there are 5 ways you can generate "bag" from S.
(The caret symbol ^ means the chosen letters)

babgbag
^^ ^
babgbag
^^    ^
babgbag
^    ^^
babgbag
  ^  ^^
babgbag
    ^^^
'''

class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        # s is the long -> use i
        # t is the short -> use j
        
        dp = [0 for i in range(len(t)+1)]
        dp[0] = 1 # 1 way to get empty substring
        
        for i in range(0, len(s)):
            for j in range(len(t), 0, -1): # reverse to avoid stepping over the current iteration
                if s[i]==t[j-1]:
                    dp[j] += dp[j-1]
        return dp[-1]

