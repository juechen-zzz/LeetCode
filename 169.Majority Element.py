"""
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
"""

# Solution 1
from typing import List


class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        dic = {}
        for i in nums:
            if i in dic:
                dic[i] += 1
            else:
                dic[i] = 1

        high = 0
        max_value = 0
        for k, v in dic.items():
            if v > max_value:
                max_value = v
                high = k
        return high


# Solution 2
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        L,d = len(nums), {}
        C = [0]*L
        for i in range(L):
            n = nums[i]
            if n not in d:
                d[n] = i
            else:
                C[d[n]] += 1
        return nums[C.index(max(C))]
