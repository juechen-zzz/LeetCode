//
//  main.cpp
//  0080_Remove Duplicates from Sorted Array II
//
//  Created by 倪浩鹏 on 2020/5/11.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 去除多余元素，每个元素最多出现2次
 
 Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 Example 1:

 Given nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.

 It doesn't matter what you leave beyond the returned length.
 Example 2:

 Given nums = [0,0,1,1,1,1,2,3,3],

 Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.

 It doesn't matter what values are set beyond the returned length.
 */

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if(nums.size() <= 1) return nums.size();
        int count = 0,j=0,i=0;
        int val = nums[0];
        while(i < nums.size()){
            if(nums[i] == val && j < 2){
                nums[count] = nums[i];
                i++;
                count++;
                j++;
            }else if(nums[i] == val && j >= 2){
                i++;
            }else if(nums[i] != val){
                val = nums[i];
                j = 0;
            }
        }
        return count;
    }
};
