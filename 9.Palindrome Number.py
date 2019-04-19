'''
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
'''

class Solution:
    def isPalindrome(self, x: int) -> bool:
        """
        :type x: int
        :rtype: bool
        """
        q = 0
        p = x
        if x < 0 :
            return False
        elif x == 0:
            return True
        while x > 0:
            q = q * 10 + x % 10
            x = x // 10		
        return q == p
            