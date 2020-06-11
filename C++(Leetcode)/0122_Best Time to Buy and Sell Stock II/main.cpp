//
//  main.cpp
//  0122_Best Time to Buy and Sell Stock II
//
//  Created by 倪浩鹏 on 2020/6/11.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
   数组前后的最大差值，后-前，可多次
*/

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.size(); i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
};
