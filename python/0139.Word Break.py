'''
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input: s = "leetcode", wordDict = ["leet", "code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple", "pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
             Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
Output: false
'''

class Solution:
    def wordBreak(self, s: str, wordDict: List[str]) -> bool:
        wordDict, cache = set(wordDict), [False] * len(s)
        for idx1 in range(len(s)):
            sub_s = s[:idx1+1]
            if sub_s in wordDict:
                cache[idx1] = True
            else:
                for idx2 in range(len(sub_s)-1,-1,-1):
                    if (cache[idx2]) and (s[idx2+1:idx1+1] in wordDict): 
                        cache[idx1] = True
                        break
        return cache[-1]