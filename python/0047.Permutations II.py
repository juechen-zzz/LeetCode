'''
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:

Input: [1,1,2]
Output:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
'''

class Solution:
    def back_track(self, nums, temp, res_all):
            if len(nums)==0: res_all.append(temp)
            for i in range(len(nums)):
                if  i>0 and nums[i]==nums[i-1]: 
                    continue
                else:
                    self.back_track(nums[:i]+nums[i+1:],temp+[nums[i]], res_all)  
    
    def permuteUnique(self, nums: List[int]) -> List[List[int]]:     
        temp=[]
        res_all=[]
        nums.sort()
        self.back_track(nums, temp, res_all)
        return res_all