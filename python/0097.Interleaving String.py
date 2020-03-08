'''
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

Example 1:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
Output: true
Example 2:

Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
Output: false
'''

class Solution:
    def isInterleave(self, s1: str, s2: str, s3: str) -> bool:
        dp = {}
        l1, l2, l3 = len(s1), len(s2), len(s3)
        if l1 + l2 != l3:
            return False

        def find(x1, x2, x3):
            if (x1, x2, x3) not in dp:
                if x1 == l1:
                    return s3[x3:] == s2[x2:]
                elif x2 == l2:
                    return s3[x3:] == s1[x1:]
                elif x3 == l3:
                    return True
                res = False
                if s3[x3] == s1[x1]:
                    res = find(x1 + 1, x2, x3 + 1)
                if not res and s3[x3] == s2[x2]:
                    res = find(x1, x2 + 1, x3 + 1)
                dp[x1, x2, x3] = res
            return dp[x1, x2, x3]

        return find(0, 0, 0)