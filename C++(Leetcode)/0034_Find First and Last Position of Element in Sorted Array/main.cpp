//
//  main.cpp
//  0034_Find First and Last Position of Element in Sorted Array
//
//  Created by 倪浩鹏 on 2020/4/9.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 在数组中找到目标第一次和最后一次出现的索引
 
 Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 Example 1:

 Input: nums = [5,7,7,8,8,10], target = 8
 Output: [3,4]
 Example 2:

 Input: nums = [5,7,7,8,8,10], target = 6
 Output: [-1,-1]
 */

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        int left=0;
        int right=nums.size()-1;
        int mid;
        
        // 先进行一系列的缩减，将二分范围缩小
        while(left<=right) {
            mid=(left+right)/2;
            if(nums[mid]==target)
                break;
            if(nums[mid]<target)
                left = mid+1;
            if(nums[mid]>target)
                right = mid-1;
        }
        
        // 未找到，返回-1
        if(right<left)
            return vector<int>({-1, -1});
        
        int right2=mid;
        int left2=mid;
        
        // 由此时找到的区间，在进行左右两个范围内的二分，左边找第一个，右边找最后一个
        while(left<=right2) {
            int mid2=(left+right2)/2;
            if(nums[mid2]<target)
                left=mid2+1;
            if(nums[mid2]==target)
                right2=mid2-1;
        }
         
        while(left2<=right) {
            int mid2=(left2+right)/2;
            if(nums[mid2]>target)
                right=mid2-1;
            if(nums[mid2]==target)
                left2=mid2+1;
        }
        return vector<int>({right2+1, left2-1});
    }
};
