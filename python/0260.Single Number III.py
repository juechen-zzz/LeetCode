"""
Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

Example:

Input:  [1,2,1,3,2,5]
Output: [3,5]

"""

class Solution:
    def singleNumber(self,nums:List[int])-> int:
        count=[]
        for num in nums:
            if num in count:
                count.remove(num)
            else:
                count.append(num)
        return count
