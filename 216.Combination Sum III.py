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
        out = []

        def sumHelper(n, k, level, sol):
            if n < 0:
                return
            if n == 0 and k == len(sol):
                out.append(sol[:])
            for i in range(level, 10):
                sol.append(i)
                sumHelper(n - i, k, i + 1, sol)
                sol.pop()

        sumHelper(n, k, 1, [])
        return out