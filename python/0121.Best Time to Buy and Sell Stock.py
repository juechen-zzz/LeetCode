"""
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before you buy one.

Example 1:

Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
Example 2:

Input: [7,6,4,3,1]
Output: 0
Explanation: In this case, no transaction is done, i.e. max profit = 0.
"""

## time limit exceeded
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        l = len(prices)
        max_profit = 0
        for i in range(l-1):
            for j in range(i+1, l):
                if max_profit < (prices[j] - prices[i]):
                    max_profit = prices[j] - prices[i]
        return max_profit


# a good answer which is using dynamic programming
class Solution(object):
    def maxProfit(self, prices):
        if prices is None or len(prices)==0: 
        	return 0   
        memo = [0]*len(prices)
        min_price = float('inf')
        
        for i in xrange(len(prices)):
            min_price = min(min_price, prices[i])
            if i==0: continue
            memo[i] = max(prices[i]-min_price, memo[i-1])
        return memo[-1]
