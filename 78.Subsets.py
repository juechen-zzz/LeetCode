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
        
        def DFS(nums,num):
            if len(num)>=0:
                self.re_num.append(num)
            for i in range(len(nums)):
                DFS(nums[i+1:],num+[nums[i]])

        DFS(nums,[])
        return self.re_num


class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        n = len(nums)
        res, p = [], 2**n
        for i in range(p):
            ans, j, pos = [], i, 0
            while j:
                if j & 1:
                    ans.append(nums[pos])
                pos += 1
                j >>= 1
            res.append(ans)
        return res