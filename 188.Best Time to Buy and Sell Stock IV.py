"""
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

Example 1:

Input: [2,4,1], k = 2
Output: 2
Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
Example 2:

Input: [3,2,6,5,0,3], k = 2
Output: 7
Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4.
             Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
"""


class Solution(object):
    def maxProfit(self, k, prices):
        """
        :type k: int
        :type prices: List[int]
        :rtype: int
        """
        # 假设极限不存在操作
        if not prices or not k:
            return 0

        # 假设操作次数超过一半，这样只要存在差值为正的都可以加上
        if k > len(prices) // 2:
            ans = 0
            for i, p in enumerate(prices[1:], 1):
                if p - prices[i - 1] > 0:
                    ans += p - prices[i - 1]
            return ans

        # 创建一个长度为len(prices)的全零数组
        s = [0] * len(prices)
        for _ in range(k):
            ans, b = 0, prices[0]
            for i, p in enumerate(prices[1:], 1):
                s[i], b = max(ans, p - b), min(b, p - s[i])
                ans = s[i]

        return ans
