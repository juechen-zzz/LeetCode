'''
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
'''
class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if not strs: return ""
        elif len(strs) == 1: return strs[0]
        else:
            min_len = min(len(s) for s in strs)
            index = 0
            for j in range(min_len):
                for i in range(len(strs)):
                    if strs[i][j] == strs[0][j]:
                        if i == len(strs)-1 and index >= j:
                            index += 1
                    else: 
                        break
            
            if index > 0:
                return strs[0][:index]
            else:
                return ""