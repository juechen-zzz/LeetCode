//
//  main.cpp
//  0031_Next Permutation
//
//  Created by 倪浩鹏 on 2020/4/2.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 返回在字典重存储的下一种排列
 
 Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place and use only constant extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 */


#include <iostream>

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int i = nums.size() - 1;
        // 首先，需要找到一个点i，使得nums[i] > nums[i-1]
        while (i - 1 >= 0){
            if (nums[i] <= nums[i-1]){
                i--;
            }
            else {
                break;
            }
        }
        
        // 如果i>=1，则部分排序，否则全部重排（即排除nums只有一个数的情况）
        if (i - 1 >= 0){
            int j = i - 1;                          // 对应1 2 3中的2
            int t = nums.size() - 1;                // 对应3
            while (nums[t] <= nums[j]){             // 反向遍历，找第一个大于nums[j]的值，再进行交换
                t--;
            }
            int temp = nums[t];
            nums[t] = nums[j];
            nums[j] = temp;
            sort(nums.begin() + i, nums.end());
        }
        else {
            sort(nums.begin(), nums.end());
        }
    }
};
