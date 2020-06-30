'''
给定一组数，返回其下一个排序
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
        # 判断nums中是否存在重复元素，改set之后若长度为1，则不用排序了
        if len(list(set(nums))) != 1:
            # 从后往前找递减序列
            while i >= 1:
                if nums[i-1] >= nums[i]:
                    i = i - 1
                else:
                    break
            
            # 递减序列断开的位置如果不为0，则需要改动，否则是纯递减，直接排序即可
            if i >= 1:
                j = i - 1
                t = len(nums) - 1
                while nums[t] <= nums[j]:       # 找第一个比nums[i-1]大的数，因为i往后是递减，直接排序
                    t -= 1
                nums[t], nums[j] = nums[j], nums[t]
                nums[i:] = sorted(nums[i:])
            else:
                nums.sort()
