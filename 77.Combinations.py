'''
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:

Input: n = 4, k = 2
Output:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
'''

class Solution(object):
    def combine(self, n, k):
        results = [[i] for i in range(1, n - k + 2)]
        for m in range(1, k):
            new_results = []
            for result in results:
                for i in range(result[-1] + 1, n - k + m + 2):
                    new_results += [result + [i]]
            results = new_results
        return results