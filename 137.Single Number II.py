'''
Given a non-empty array of integers, every element appears three times except for one, which appears exactly once. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,3,2]
Output: 3
Example 2:

Input: [0,1,0,1,0,1,99]
Output: 99
'''

class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        ans = 0
        for i in range(len(nums)-1):
            if (nums[i] in nums[i + 1:]) or (nums[i] in nums[:i - 1]):
                continue
            else:
                ans = nums[i]
        if nums[len(nums)-1] not in nums[:len(nums)-2]:
            ans = nums[len(nums)-1]
        return ans