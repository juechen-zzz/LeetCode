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

class Solution(object):
    def permute(self, nums):
        if len(nums) <= 1:
            return [nums]
        result = []
        self.heapPermutation(nums, len(nums), result)
        return result
        
    def heapPermutation(self, a, size, result):
        if size == 1:
            result.append(a[:])

        size1 = size - 1
        is_size_odd = size % 2 == 1

        for i in range(size):
            self.heapPermutation(a, size1, result)    

            if is_size_odd:
                if 0 != size1:
                    a[0], a[size1] = a[size1], a[0]
            else:
                if i != size1:
                    a[i], a[size1] = a[size1], a[i]