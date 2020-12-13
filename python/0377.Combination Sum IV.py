"""
给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。

示例:

nums = [1, 2, 3]
target = 4

所有可能的组合为：
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

请注意，顺序不同的序列被视作不同的组合。

因此输出为 7。

"""

class Solution:
    def combinationSum4(self, nums: List[int], target: int) -> int:
        cache = [0] * (target+1)
        cache[0] = 1
        for i in range(1, len(cache)):
            for num in nums:
                if i - num >= 0:
                    cache[i] += cache[i-num]
        return cache[-1]