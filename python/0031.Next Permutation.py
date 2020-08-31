'''
给定一组数，返回其下一个排序
Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
'''

class Solution:
    def nextPermutation(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        index = len(nums)-1
        while index >= 1:                       # 从后往前找递减序列
            if nums[index-1] >= nums[index]:
                index -= 1
            else:
                break
        
        if index >= 1:                          # 递减序列断开的位置如果不为0，则需要改动，否则是纯递减，直接排序即可
            l = index - 1
            r = len(nums) - 1
            while nums[r] <= nums[l]:
                r -= 1
            nums[l], nums[r] = nums[r], nums[l]
            nums[index:] = sorted(nums[index:])
        else:
            nums.sort()
