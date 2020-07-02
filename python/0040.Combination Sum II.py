'''
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

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
        dp = [[] for _ in range(target+1)]
        for val in candidates:
            for i in reversed(range(val,target+1)):     # 返回一个反转的迭代器，也就从这和39题区别开
                if i==val:
                    dp[i].append([val])
                else:
                    for _list in dp[i-val]:
                        l = _list + [val]
                        dp[i].append(l)
                    
        # dp[-1]: [[6], [1, 5], [1, 5]], 然后排除重复的组合（同一数字在数组中多次出现的情况）
        res = []
        for i in dp[-1]:
            if sorted(i) not in res:
                res.append(sorted(i))
        return res