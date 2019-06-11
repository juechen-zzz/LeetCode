'''
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
'''

import functools

class Solution:
    def numTrees(self, n: int) -> int:
        @functools.lru_cache(None)
        def dp(low, high):
            if low >= high:
                return 1
            res = 0
            for mid in range(low, high+1):
                 res += dp(low, mid-1) * dp(mid+1, high)
            return res
        return dp(1, n)