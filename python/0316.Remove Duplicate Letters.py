"""
Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.

Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/

 

Example 1:

Input: s = "bcabc"
Output: "abc"
Example 2:

Input: s = "cbacdcbc"
Output: "acdb"
"""

class Solution:
    def removeDuplicateLetters(self, s):
        last_occ = {v: k for k, v in enumerate(s)}
        visited = set()
        stack = ["!"]
        for k, v in enumerate(s):
            if v in visited: continue
            # 判断如果不是逻辑顺序并且后面还会出现就删除
            while v < stack[-1] and last_occ[stack[-1]] > k:
                visited.remove(stack.pop())
            visited.add(v)
            stack.append(v)
        return "".join(stack)[1:]