"""
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
"""


def isIsomorphic(s: str, t: str) -> bool:
    d1, d2 = {}, {}
    # zip()用于将可迭代的对象作为参数，将对象中对应的元素打包成一个个元组，然后返回由这些元组组成的列表
    for a, b in zip(s, t):
        if a in d1 and d1[a] != b or b in d2 and d2[b] != a:
            return False
        d1[a], d2[b] = b, a
    return True


