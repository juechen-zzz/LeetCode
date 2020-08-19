"""
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
"""

class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        num_set = set(nums)
        for number in range(len(nums)+1):
            if number not in num_set:
                return number
