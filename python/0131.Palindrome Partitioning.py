'''
Given a string s, partition s such that every substring of the partition is a palindrome.

Return all possible palindrome partitioning of s.

Example:

Input: "aab"
Output:
[
  ["aa","b"],
  ["a","a","b"]
]
'''

class Solution:
    def partition(self, s: str) -> List[List[str]]:
        self.res = []
        self.helper(s, [])
        return self.res
    
    def helper(self, s, tmp):
            if not s: self.res.append(tmp)
            for i in range(1, len(s) + 1):
                if s[:i] == s[:i][::-1]:
                    self.helper(s[i:], tmp + [s[:i]])
