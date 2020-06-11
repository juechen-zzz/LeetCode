//
//  main.cpp
//  0121_Best Time to Buy and Sell Stock
//
//  Created by 倪浩鹏 on 2020/6/11.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    数组前后的最大差值，后-前
 */

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int max_profit = 0;
        int min_price = INT_MAX;
        for (int i = 0; i < prices.size(); i++){
            if (prices[i] < min_price){
                min_price = prices[i];
            }
            else if (prices[i]-min_price > max_profit){
                max_profit = prices[i] - min_price;
            }
        }
        return max_profit;
    }
};
