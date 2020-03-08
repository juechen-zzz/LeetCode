'''
Given a string s, partition s such that every substring of the partition is a palindrome.

Return the minimum cuts needed for a palindrome partitioning of s.

Example:

Input: "aab"
Output: 1
Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.
'''

class Solution(object):
    def minCut(self, s):
        """
        :type s: str
        :rtype: int
        """
        dp = [i for i in range(len(s))]
        isPalin = [[False for _ in range(len(s))] for _ in range(len(s))] 
        for i in range(0,len(s)):
            for j in range(0,i+1):
                if s[i]==s[j] and (i<=j+1 or isPalin[j+1][i-1]):
                    isPalin[j][i] = True
                    dp[i] = min(dp[i],dp[j-1]+1) if j !=0  else 0
        return dp[len(s)-1]