'''
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
'''

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        # bisect.bisect返回的是插入索引的位置,存在时返回x左/右侧的位置
        i = bisect.bisect_left(nums, target)
        if i == len(nums) or nums[i] != target: return [-1, -1]
        j = bisect.bisect_right(nums, target)
        return [i, j-1]