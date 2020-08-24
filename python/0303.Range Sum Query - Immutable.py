"""
Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

Example:

Given nums = [-2, 0, 3, -5, 2, -1]

sumRange(0, 2) -> 1
sumRange(2, 5) -> -1
sumRange(0, 5) -> -3

"""

class NumArray:
    def __init__(self, nums: List[int]):
        self.arr=[0]
        for i in range(len(nums)):
            self.arr.append(self.arr[i] + nums[i])

    def sumRange(self, i: int, j: int) -> int:
        return self.arr[j+1]-self.arr[i]



# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# param_1 = obj.sumRange(i,j)