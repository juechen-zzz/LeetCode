'''
leetcode 5

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
'''

def longestPalindrome(self, s):
    """
    :type s: str
    :rtype: str
    """
    max = 0
    palindromic = '' if len(s) == 0 else s[0]
    for i in range(len(s)):
        length = 1
        while i - length >= 0 and i + length < len(s) and s[i-length] == s[i+length]:
            tmp = s[i-length:i+length+1]
            if len(tmp) > max:
                 max = len(tmp)
                palindromic = tmp
            length += 1
        length = 1
        while i - length + 1  >=0 and i + length < len(s) and s[i-length+1] == s[i+length]:
            tmp = s[i-length+1:i+length+1]
            if len(tmp) > max:
                max = len(tmp)
                palindromic = tmp
            length += 1
    return palindromic