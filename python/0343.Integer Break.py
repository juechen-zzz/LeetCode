"""
给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
"""

class Solution:
    def integerBreak(self, n: int) -> int:
        dp = [1] * (n + 1)
        for i in range(3, n+1):
            for j in range(1, int(i / 2) + 1):
                # 会出现极限情况，比如dp[2]=1，不应该拆2的
                dp[i] = max(dp[i], max(dp[i-j], i-j) * max(dp[j], j))
        return dp[-1]
