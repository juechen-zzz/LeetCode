'''
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

Example:

Given array nums = [-1, 2, 1, -4], and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
'''


class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        res = float('inf')
        for i in range(len(nums)-2):
            l,r = i + 1,len(nums) - 1            
            while l < r:
                sum = nums[i] + nums[l] + nums[r]
                if sum == target:return target
                elif sum > target:r -= 1
                else:l += 1
                if abs(sum - target) < abs(res - target):res = sum
        return res
