//
//  main.cpp
//  0001_Two Sum
//
//  Created by 倪浩鹏 on 2020/3/12.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:

 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */

#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        std::map<int, int> number;
        vector<int> result;
        
        for(int i = 0; i<nums.size(); i++){
            int tag = target-nums[i];
            // count返回被查找元素的个数，有则为1，后边则是因为题目要求不能用相同的元素两次
            if(number.count(tag) && number[tag] !=i){
                result.push_back(number[tag]);
                result.push_back(i);
                break;
            }
            // 存储值-键对
            number[nums[i]] = i;
        }
        return result;
    }
};
