'''
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

Example 1:

Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
Example 2:

Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []
'''
class Solution(object):
    def findSubstring(self, s, words):
        """
        :type s: str
        :type words: List[str]
        :rtype: List[int]
        """
        if words==[]: return []
        res=[]
        adict={}
        l=len(words[0])
        count=len(words)
        ls=len(s)
        dp1=[0]*count
        for index in range(count):
            ws=words[index]
            if ws in adict:
                index=adict[ws]
            else:
                adict[ws]=index
            dp1[index]+=1
        for i in range(len(s)-l*count+1):
            curl=i
            dp=dp1[:]
            while curl+l<=ls and s[curl:curl+l] in adict:
                index=adict[s[curl:curl+l]]
                dp[index]-=1
                if dp[index]<0:
                    break 
                curl+=l
            if curl-i==count*l:
                res.append(i)
        return res
