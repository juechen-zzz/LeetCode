"""
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Note:

All numbers will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6], [1,3,5], [2,3,4]]
"""


class Solution:
    def combinationSum3(self, k: int, n: int) -> List[List[int]]:
        res = []
        
        def DFS(num, k, n, cur_sum, tmp):
            if len(tmp) == k and cur_sum == n:
                res.append(tmp[:])
                return
            for i in range(num, 10):
                if cur_sum + i <= n and len(tmp) < k:
                    tmp.append(i)
                    cur_sum += i
                    DFS(i+1, k, n, cur_sum, tmp)
                    tmp.pop()
                    cur_sum -= i
                    
        DFS(1, k, n, 0, [])
        return res