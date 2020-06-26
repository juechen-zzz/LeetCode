'''
字符串匹配，有特殊字符（万能） 
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
    def isMatch(self, s: str, p: str) -> bool:
        s_len, p_len = len(s), len(p)
        if p_len == 0:return s_len == 0

        # 首先判断len(p)>1 and p[1]=="*"，如果是的话，说明*在p的第二位，我们就要判断s[0]和p[0]能否匹配，
        # 如果可以匹配的话，我们继续判断isMatch(s[1:], p)（也就是*匹配了一次，我们会继续使用.*或者?*去参与比较），
        # 同时需要判断isMatch(s,p[2:])是不是成立（也就是*表示匹配0次）
        if p_len > 1 and p[1] == "*":
            return self.isMatch(s, p[2:]) or \
                (s_len != 0 and (s[0] == p[0] or p[0] == '.') and self.isMatch(s[1:], p))
        # 如果*不在p的第二位，我们就要判断s[0]和p[0]能否匹配
        else:
            return s_len != 0 and (s[0] == p[0] or p[0] == '.') and self.isMatch(s[1:], p[1:]) 
