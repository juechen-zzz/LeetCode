'''
Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
'''

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        if len(nums) <= 1: return [nums]
        res = []
        for idx, num in enumerate(nums):
            res_nums = nums[:idx] + nums[idx + 1:]  # 确定剩余元素
            for j in self.permute(res_nums):  
                res.append([num] + j)
        return res
