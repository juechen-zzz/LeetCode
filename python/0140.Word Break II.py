'''
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
'''

import collections
class Solution(object):
    def wordBreak(self, string, wordList):
		# i created wordDict as dictionary so that search is faster
        wordDict = collections.Counter(wordList)
        dp = {}
        
        def helper(s):
            #return the list of segmented strings of s
            if s in dp:
                return dp[s]
            res = []
            if s=="":
                return [""]
            for i in range(len(s)):
                if s[:i+1] in wordDict:
                    l = helper(s[i+1:])
                    for p in l:
                        if p != "":
                            res.append(s[:i+1]+" "+p)
                        else:
                            res.append(s[:i+1])
            dp[s] = res
            return res
        
        return helper(string)