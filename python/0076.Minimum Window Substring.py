'''
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
Note:

If there is no such window in S that covers all characters in T, return the empty string "".
If there is such window, you are guaranteed that there will always be only one unique minimum window in S.



You can understand this method as follows:

In the first step, you should count every character in string t;
Then you should traverse the string s.; When you find a character in string t, make the char['c'] minus 1. Then the variable counts minus 1 when you find the char['c'] > 0;
When the counts = 0, which means you have find a substring that contains all characters in strring t, Now you should just find the first character in this substring which is in the string t and the char['c'] = 0. Now you get the shortest substring so far.
Then set the counts =1 and the char['the first character you found in substring'] += 1.
'''

class Solution:
    def minWindow(self, s: str, t: str) -> str:
        char = {}
        counts = len(t)
		
        for i in t:
            if i not in char.keys():
                char[i] = 1
            else:
                char[i] += 1
        
        i, I, J = 0, 0, 0
        
        for j in range(len(s)):
            if s[j] in t:
                char[s[j]] -= 1
                if char[s[j]] >= 0: counts -= 1
                
                if counts == 0:
                    for k in range(i, j+1):
                        if s[k] not in t: continue
                        if char[s[k]] == 0:
                            i = k
                            break
                        else:
                            char[s[k]] += 1
                        
                    if not J or j - i + 1 < J - I:  I, J = i, j+1
                        
                    char[s[i]] += 1; counts += 1; i += 1
        
        return s[I:J]