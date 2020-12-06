"""
    给定一个数组，返回数组中的满足要求的最大子数组
    要求：数组中任意两个数x, y 满足 x % y = y % x = 0

Example 1:
Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)

Example 2:
Input: [1,2,4,8]
Output: [1,2,4,8]
"""

class Solution:
    def largestDivisibleSubset(self, nums: List[int]) -> List[int]:
        nums = sorted(nums)     
        dp = [[] for _ in range(len(nums))]
        res = []
        for i in range(len(nums)):
            temp = []   
            for j in range(i):
                if nums[i] % nums[j] == 0 and len(dp[j]) > len(temp): 
                    temp = dp[j]
            dp[i] = temp + [nums[i]] 
            if len(dp[i]) > len(res): 
                res = dp[i]
        return res
