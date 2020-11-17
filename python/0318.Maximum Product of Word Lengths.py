"""
Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.

Example 1:

Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
Output: 16 
Explanation: The two words can be "abcw", "xtfn".
Example 2:

Input: ["a","ab","abc","d","cd","bcd","abcd"]
Output: 4 
Explanation: The two words can be "ab", "cd".
Example 3:

Input: ["a","aa","aaa","aaaa"]
Output: 0 
Explanation: No such pair of words.
"""

# solution 1
class Solution:
    def maxProduct(self, words: List[str]) -> int:
        lib = {word: set(word) for word in words}        
        res = 0
        for i, word1 in enumerate(words[:-2]):
            for j, word2 in enumerate(words[i+1:]):
                # 判断两个集合是否有交集(判断是否有重复字符的方法)
                if not lib[word1] & lib[word2]: 
                    res = max(res, len(word1) * len(word2))
        return res

# solution 2：Brute
class Solution:
    def withSameLetter(self, s1, s2):
        if len(s1) < 1 or len(s2) < 1: return False
        for s in s1:
            if s in s2: return True
        return False
        
    def maxProduct(self, words: List[str]) -> int:
        if len(words) < 2: return 0
        ans = 0
        for i in range(len(words)-1):
            for j in range(i, len(words)):
                if self.withSameLetter(words[i], words[j]): continue
                else:
                    ans = max(ans, len(words[i]) * len(words[j]))
        return ans

