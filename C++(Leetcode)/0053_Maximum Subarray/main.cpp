//
//  main.cpp
//  0053_Maximum Subarray
//
//  Created by 倪浩鹏 on 2020/4/20.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 最大子列和
 
 Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

 Example:

 Input: [-2,1,-3,4,-1,2,1,-5,4],
 Output: 6
 Explanation: [4,-1,2,1] has the largest sum = 6.
 */

#include <iostream>

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int ans = nums[0];
        int temp = ans;
        for (int i = 1; i < nums.size(); i++){
            if (temp < 0) {temp = 0;}
            temp += nums[i];
            if (temp > ans) {
                ans = temp;
            }
        }
        return ans;
    }
};
