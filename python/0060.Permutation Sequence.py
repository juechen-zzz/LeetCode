'''
The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"

'''

# 超时
class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        i = 0
        nums = list(range(n+1))
        nums.pop(0)
        res = self.permute(nums)
        return ''.join(map(str, list(res[k-1])))

    def permute(self, nums: List[int]) -> List[List[int]]:
        if len(nums) <= 1: return [nums]
        res = []
        for idx, num in enumerate(nums):
            res_nums = nums[:idx] + nums[idx + 1:]  # 确定剩余元素
            for j in self.permute(res_nums):  
                res.append([num] + j)
        return res

# 
class Solution:
    def getPermutation(self, n: int, k: int) -> str:
        arr = list(permutations(list(range(1, n+1))))
        return ''.join(map(str, arr[k-1]))