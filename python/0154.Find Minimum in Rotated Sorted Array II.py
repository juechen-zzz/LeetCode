'''
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

The array may contain duplicates.

Example 1:

Input: [1,3,5]
Output: 1
Example 2:

Input: [2,2,2,0,1]
Output: 0
'''

# answer 1
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) < 1:
            return
        if len(nums) == 1:
            return nums[0]
        ans = nums[0]
        for i in range(len(nums)):
            if nums[i] < ans:
                ans = nums[i]
        return ans

# answer 2
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return nums[0]
        if nums[0] < nums[-1]:
            return nums[0]
        else:
            mid = len(nums) // 2
            return min(self.findMin(nums[:mid]), self.findMin(nums[mid:]))