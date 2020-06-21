'''
leetcode 1

给定一个数组，找到数组中两数和为给定值，返回两数的索引
 
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
'''
def twoSum(self, nums, target):
    """
    :type nums: List[int]
    :type target: int
    :rtype: List[int]
    """
    d = {}
    for i, n in enumerate(nums):
        m = target - n
        if m in d:
            return [d[m], i]
        else:
            # 字典中存储值-键对
            d[n] = i
