"""
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
"""

class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        nums = sorted(nums, key = self.bi, reverse = True)
        if nums[0] == 0: return "0"
        return "".join([str(i) for i in nums])

    def bi(self, x):
        if x == 0: return 0
        s, k = 0, x
        while x >= 1:
            x = x / 10
            s += 1
        return k /( 10 **s -1)
