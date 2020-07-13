'''
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
'''

class Solution:
    def subsets(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """

        self.re_num=[]
        
        def DFS(nums,n):
            if len(n)>=0:
                self.re_num.append(n)
            for i in range(len(nums)):
                DFS(nums[i+1:],n+[nums[i]])

        DFS(nums,[])
        return self.re_num

