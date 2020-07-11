'''
Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
'''
# 只有有一次加非9加1就停，如果第一位是9，就补一个1
class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        l = len(digits)
        digits.reverse()
        for i in range(l):
            if digits[i] == 9:
                digits[i] = 0
                if i == l - 1: digits.append(1)
            else:
                digits[i] += 1
                break
        digits.reverse()
        return digits