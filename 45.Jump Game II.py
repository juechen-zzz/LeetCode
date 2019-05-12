'''
Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

Example:

Input: [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2.
    Jump 1 step from index 0 to 1, then 3 steps to the last index.
'''

class Solution:
    def jump(self, nums):
        if len(nums) <= 1: return 0
        l, r = 0, nums[0]
        times = 1
        while r < len(nums) - 1:
            times += 1
            nxt = max(i + nums[i] for i in range(l, r + 1))
            l, r = r, nxt
        return times