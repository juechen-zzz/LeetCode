"""
Given a list of non negative integers, arrange them such that they form the largest number.

Example 1:

Input: [10,2]
Output: "210"
Example 2:

Input: [3,30,34,5,9]
Output: "9534330"
"""

class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        def quickSortHelper(alist, first, last):
            if first < last:
                splitpoint = self.partition(alist, first, last)
                quickSortHelper(alist, first, splitpoint - 1)
                quickSortHelper(alist, splitpoint + 1, last)
        nums = list(map(str, nums))
        quickSortHelper(nums, 0, len(nums) - 1)
        return ''.join(nums).lstrip('0') or '0'

    def compare(self, a, b):
        return str(a) + str(b) < str(b) + str(a)

    def partition(self, alist, first, last):

        pivotvalue = alist[last]
        leftmark = first
        rightmark = last - 1

        while leftmark <= rightmark:
            if not self.compare(alist[leftmark], pivotvalue):
                leftmark = leftmark + 1

            else:
                alist[rightmark], alist[leftmark] = alist[leftmark], alist[rightmark]
                rightmark = rightmark - 1

        alist[last], alist[leftmark] = alist[leftmark], alist[last]
        return leftmark  