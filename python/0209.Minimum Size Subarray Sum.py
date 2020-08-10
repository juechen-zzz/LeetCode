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
    def minSubArrayLen(self, s: int, nums: List[int]) -> int:
        n = len(nums)
        cur_sum = 0
        min_len = float('inf')
        index = 0
        for i in range(n):
            while cur_sum < s and index < n:
                cur_sum += nums[index]
                index += 1
            if cur_sum >= s:
                min_len = min(min_len, index-i)
                cur_sum = cur_sum - nums[i]
        return 0 if min_len == float('inf') else min_len
