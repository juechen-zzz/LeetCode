//
//  main.cpp
//  0035_Search Insert Position
//
//  Created by 倪浩鹏 on 2020/4/10.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    在一个有序数组中找到元素索引，数组中不存在则返回应该插入位置的索引
 
     Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

     You may assume no duplicates in the array.

     Example 1:

     Input: [1,3,5,6], 5
     Output: 2
     Example 2:

     Input: [1,3,5,6], 2
     Output: 1
     Example 3:

     Input: [1,3,5,6], 7
     Output: 4
     Example 4:

     Input: [1,3,5,6], 0
     Output: 0
 */

class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int ans = -1;
        if (target < nums[0]){return 0;}
        if (target > nums[nums.size()-1]){return nums.size();}
        for (int i = 0; i < nums.size(); i++){
            if (nums[i] == target || nums[i] > target){
                ans = i;
                break;
            }
        }
        return ans;
    }
};
