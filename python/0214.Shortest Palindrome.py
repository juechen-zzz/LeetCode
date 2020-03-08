"""
Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

Example 1:

Input: "aacecaaa"
Output: "aaacecaaa"
Example 2:

Input: "abcd"
Output: "dcbabcd"
"""


class Solution:
    def shortestPalindrome(self, s: str) -> str:
        A = s + "#" + s[::-1]
        lps = [0] * len(A)
        i, j = 1, 0
        while (i < len(A)):
            # print("i=",i,"j=",j)
            if (A[i] == A[j]):
                j += 1
                lps[i] = j
                i += 1
            else:
                if (j != 0):
                    j = lps[j - 1]
                else:
                    lps[i] = 0
                    i += 1
        return (s[lps[-1]:][::-1] + s)
