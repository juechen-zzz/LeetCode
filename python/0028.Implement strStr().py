'''
Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2
Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1
'''

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(haystack) < len(needle): return -1
        n_len = len(needle)
        for i in range(len(haystack)-len(needle)+1):
            if haystack[i: i+n_len] == needle:
                return i
        return -1