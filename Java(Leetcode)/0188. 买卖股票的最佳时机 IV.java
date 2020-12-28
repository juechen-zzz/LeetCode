/* 
给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

 

示例 1：

输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
示例 2：

输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

 */

// DP
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n < 2) return 0;

        // 如果k超过了最大可买卖次数，那就将k置为最大买卖次数
        // 最大买卖次数就是天数的一半，如果当前卖出又买入，是没有意义的
        k = Math.min(k, n / 2);

        int[] buy = new int[k + 1];
        int[] pro = new int[k + 1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        Arrays.fill(pro, Integer.MIN_VALUE);
        buy[0] = 0;
        pro[0] = 0;

        for (int i = 0; i < n; i++){
            for (int j = 1; j <= k; j++){
                buy[j] = Math.min(buy[j], prices[i] - pro[j - 1]);
                pro[j] = Math.max(pro[j], prices[i] - buy[j]);
            }
        }

        return pro[k];
    }
}
