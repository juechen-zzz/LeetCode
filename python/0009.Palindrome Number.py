'''
判断数字是否回文，负数直接False
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
        if (x < 0): return False
        temp = x
        ans = 0
        while temp > 0:
            ans = ans * 10 + temp % 10
            temp = temp // 10
        return ans == x