'''
leetcode 3

Given a string, find the length of the longest substring without repeating characters.

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
def lengthOfLongestSubstring(self, s):
    """
    :type s: str
    :rtype: int
    """
    start = 0 
    max_length = 0
    substring = {}
    for i, c in enumerate(s):
        if c in substring and start <= substring[c]:
            start = substring[c] + 1
        else:
            max_length = max(max_length, i - start + 1)
        substring[c]             
    return max_length
