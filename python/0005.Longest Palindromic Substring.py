'''
给定字符串，返回最大回文子串
Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
'''

class Solution:
	def longestPalindrome(self, s: str) -> str:
		p, idx = '', 0
		while idx < len(s):
            # 左右指针
			l = r = idx
			while l-1 >= 0 and s[l] == s[l-1]: 
                l -= 1
			while r+1 < len(s) and s[r] == s[r+1]: 
                r += 1
			idx = r + 1 
			while l >= 0 and r < len(s) and s[l] == s[r]: 
				l, r = l-1, r+ 1
            # 将两个字符串对比长度并保留长的，一种高级写法
			p = max([p, s[l+1:r]], key = lambda x:len(x))
		return p
