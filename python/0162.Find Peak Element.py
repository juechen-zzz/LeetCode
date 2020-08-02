'''
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -∞.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
'''

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        return nums.index(max(nums))  # 返回最大值的index就好了

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        left, right = 0, len(nums) - 1
        while left < right:
            mid = left + (right - left) // 2 # 防止溢出
            if nums[mid] > nums[mid + 1]:  # 如果满足该条件说明山峰可能是在 mid 的左侧，因为各个元素不同，所以if的条件是 >
                right = mid
            else:
                left = mid + 1
        return left

