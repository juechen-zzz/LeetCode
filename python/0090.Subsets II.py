'''
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
'''

class Solution:
    def subsetsWithDup(self, nums: List[int]) -> List[List[int]]:
        res = last = [[]]
        nums.sort()
        for ind, n in enumerate(nums):
            # use it or lose
            last = [s + [n] for s in (res if ind == 0 or nums[ind - 1] != nums[ind] else last)]
            res += last
        
        return res