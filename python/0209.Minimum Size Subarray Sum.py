"""
Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

Example:

Input: s = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: the subarray [4,3] has the minimal length under the problem constraint.
Follow up:
If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

"""


class Solution:
    def minSubArrayLen(self, s, nums):

        # sliding window
        n = len(nums)
        cur_sum = 0
        min_len = float('inf')
        j = 0
        for i in range(n):
            while (cur_sum < s and j < n):
                cur_sum += nums[j]
                j += 1
            if cur_sum >= s:
                min_len = min(j - i, min_len)
                cur_sum = cur_sum - nums[i]
                print(min_len, cur_sum)
        return 0 if min_len == float('inf') else min_len

