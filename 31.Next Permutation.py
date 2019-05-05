'''
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
'''

class Solution:
    def nextPermutation(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        i = len(nums) - 1
        if len(list(set(nums))) != 1:
            while i - 1 >= 0:
                if nums[i] <= nums[i - 1]:
                    i = i - 1
                else:
                    break

            if i - 1 >= 0:
                j = i - 1
                t = len(nums) - 1
                while nums[t] <= nums[j]:
                    t -= 1
                
                nums[t], nums[j] = nums[j], nums[t]
                nums[i:] = sorted(nums[i:])
            else:
                nums.sort()
