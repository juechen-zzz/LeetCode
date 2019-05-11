'''
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like ? or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
Example 3:

Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
Example 4:

Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
Example 5:

Input:
s = "acdcb"
p = "a*c?b"
Output: false
'''

class Solution:
    def isMatch(self, s, p):
        si,pi,pr,sr=0,0,-1,-1
        while si<len(s):
            if pi<len(p) and p[pi]=='*':
                pi+=1
                pr=pi
                sr=si
            elif pi<len(p) and (p[pi]=='?' or p[pi]==s[si]):
                pi+=1
                si+=1
            elif pr!=-1:
                pi=pr
                sr+=1
                si=sr
            else:
                return False

        while(pi<len(p) and p[pi]=='*'):
            pi+=1

        return pi==len(p)
