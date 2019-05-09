'''
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

Each number in candidates may only be used once in the combination.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8,
A solution set is:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5,
A solution set is:
[
  [1,2,2],
  [5]
]
'''

class Solution:
    def combinationSum2(self, candidates: List[int], target: int) -> List[List[int]]:
        import copy
        dp = [[] for _ in range(target+1)]
        for can in candidates:
            for i in reversed(range(can,target+1)):
                if dp[i-can]:
                    for j in dp[i-can]:
                        met = copy.copy(j)
                        met.append(can)
                        dp[i].append(met)
                elif i==can:
                    dp[i].append([can])
        res = []
        for i in dp[-1]:
            if sorted(i) not in res:
                res.append(sorted(i))
        return res