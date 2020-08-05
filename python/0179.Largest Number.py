"""
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
"""

class Solution(object):
    def bi(self, i):
        if i == 0: return 0
        s = 0
        k = i
        while i >= 1:
            i=i/ 10
            s+=1
        return k /( 10 **s -1)          # 12/99=0.1212...

    def largestNumber(self, nums):
        nums = sorted(nums,key = self.bi,reverse=True)
        if nums[0] == 0: return "0"
        return "".join([str(i) for i in nums])
