"""
反转一个字符串中的元音字母
"""

class Solution:
    def reverseVowels(self, s: str) -> str:
        if len(s) == 0:return ''
        i, j = 0, len(s)-1
        v = ['a','e','i','o','u','A','E','I','O','U']
        ans = list(s)
        while j >= i:
            if ans[i] in v:
                if ans[j] in v:
                    ans[i], ans[j] = ans[j], ans[i]
                    i+=1
                    j-=1
                else:
                    j-=1
            else:
                i+=1
        return ''.join(ans)