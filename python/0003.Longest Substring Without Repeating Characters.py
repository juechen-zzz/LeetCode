'''
给定一个字符串，返回其中无重复最大子串的长度
Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0 or len(s) == 1: return len(s)
        
        max_len = 1
        index = 0
        substr = {}
        for k, v in enumerate(s):
            # 字典中查找的是键（key）
            if v in substr and index <= substr[v]:
                index = substr[v] + 1
            else:
                max_len = max(max_len, k-index+1)
            substr[v] = k
        return max_len
