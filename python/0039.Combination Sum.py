'''
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中可以多次使用。  
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
'''

class Solution:
    def combinationSum(self, candidates, target):
      # 该函数返回一个类似字典的对象,默认为None。使用list作第一个参数，可以很容易将键-值对序列转换为列表字典
        dp = [[] for _ in range(target+1)]
        for val in candidates:
            for j in range(val,target + 1):
                if j - val == 0:
                    dp[j].append([val])
                else:
                    for _list in dp[j-val]:
                        l = _list + [val]
                        dp[j].append(l)
        return dp[target]