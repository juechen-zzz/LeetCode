"""
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
Example:

Input: [1,2,3,0,2]
Output: 3 
Explanation: transactions = [buy, sell, cooldown, buy, sell]

首先量取prices的长度为n，对n进行判断，接着以[0,0]为一个单位对n进行循环得到dp
dp[][]这两个框前面代表天数，后面代表是否持有股票
dp[i][0]就是i-1天不持股或者i-1天持股然后i天卖出
dp[i][1]则不同了，按照我们正常的理解应该是i-1天持股或者i-1天不持股然后第i天持股
但是我们这里有一个冷冻期，是需要隔一天的，这里dp[i-2][0]是利润，而dp[i-2][0]有可能是i-3天不持股或者i-3天持股i-2天卖出,
无论哪种选择，当到dp[i][1]的时候如果是dp[i-1][0]是没有冷冻期的，只有是dp[i-2][0]中间才有i-1这一天作为冷冻期
最后返回dp[-1][0]因为不持股利润是要大于等于持股的(价格等于0相等)

"""

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        n = len(prices)
        if n < 2: return 0
        dp = [[0,0] for i in range(n)]   #dp的初始化

        dp[0][0] = 0            #第0天不持股自然就为0了
        dp[0][1] = -prices[0]   #第0天持股，那么价格就是-prices[0]了
        #第1天不持股，要么第0天就不持股，要么就是第0天持股，然后第1天卖出
        dp[1][0] = max(dp[0][0], dp[0][1]+prices[1]) 
        #第1天持股，要么就是第0天就持股了，要么就是第0天不持股第1天持股
        dp[1][1] = max(dp[0][1],dp[0][0]-prices[1])
        for i in range(2,n):
            dp[i][0] = max(dp[i-1][0], dp[i-1][1]+prices[i])
            dp[i][1] = max(dp[i-1][1], dp[i-2][0]-prices[i])
        return dp[-1][0]
