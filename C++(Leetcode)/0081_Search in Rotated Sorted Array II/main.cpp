//
//  main.cpp
//  0081_Search in Rotated Sorted Array II
//
//  Created by 倪浩鹏 on 2020/5/11.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 旋转数组查找
 
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

 You are given a target value to search. If found in the array return true, otherwise return false.

 Example 1:

 Input: nums = [2,5,6,0,0,1,2], target = 0
 Output: true
 Example 2:

 Input: nums = [2,5,6,0,0,1,2], target = 3
 Output: false
 */

class Solution {
public:
    bool search(vector<int>& nums, int target) {
        if (nums.empty()) return false;
        
        int l = 0, r = nums.size() - 1, m;
        
        while (l <= r) {
            m = (l + r) / 2;
            
            if (nums[m] == target) return true;
            
            if (nums[l] < nums[m]) {
                if (nums[l] <= target && nums[m] > target) r = m - 1;
                else l = m + 1;
            }
            
            else if (nums[l] == nums[m]) {
                l++;
            }
            
            else {
                if(nums[m] < target && nums[r] >= target) l = m + 1;
                else r = m - 1;
            }
        }
        
        return false;
    }
};
