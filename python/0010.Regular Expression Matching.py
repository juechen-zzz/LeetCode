'''
leetcode 10

Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.
The matching should cover the entire input string (not partial).

Note:

s could be empty and contains only lowercase letters a-z.
p could be empty and contains only lowercase letters a-z, and characters like . or *.
Example 1:

Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
Example 2:

Input:
s = "aa"
p = "a*"
Output: true
Explanation: '*' means zero or more of the precedeng element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
Example 3:

Input:
s = "ab"
p = ".*"
Output: true
Explanation: ".*" means "zero or more (*) of any character (.)".
Example 4:

Input:
s = "aab"
p = "c*a*b"
Output: true
Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore it matches "aab".
Example 5:

Input:
s = "mississippi"
p = "mis*is*p*."
Output: false
'''

class Solution:
    def isMatch(self, s, p):
        """
        :type s: str
        :type p: str
        :rtype: bool
        """
        pl=len(p)
        sl=len(s)
        if pl==0: return sl==0  
        
        if pl==1:
            return sl==1 and (s[0] == p[0] or p[0] =='.')
        
        if p[1] != '*':
            if sl ==0 : return False
            return (s[0]==p[0] or p[0]=='.') and self.isMatch(s[1:],p[1:])
        
        while (len(s) !=0 and (s[0]==p[0] or p[0]=='.')):
            if self.isMatch(s,p[2:]): return True
            s=s[1:]
            
        return self.isMatch(s,p[2:])
