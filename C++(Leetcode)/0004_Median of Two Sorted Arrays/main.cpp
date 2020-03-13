//
//  main.cpp
//  0004_Median of Two Sorted Arrays
//
//  Created by 倪浩鹏 on 2020/3/14.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 There are two sorted arrays nums1 and nums2 of size m and n respectively.

 Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

 You may assume nums1 and nums2 cannot be both empty.

 Example 1:

 nums1 = [1, 3]
 nums2 = [2]

 The median is 2.0
 Example 2:

 nums1 = [1, 2]
 nums2 = [3, 4]

 The median is (2 + 3)/2 = 2.5
 */

#include <iostream>

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();
        int s = m+n;
        vector<int> nums;
        
        for(int i=0;i<m;i++){
            nums.push_back(nums1[i]);
        }
        for(int i=0;i<n;i++){
            nums.push_back(nums2[i]);
        }
        sort(nums.begin(), nums.end());
        
        double ans=0.0;
        if(s%2!=0){
            ans=nums[s/2];
        }else{
            int t = nums[s/2]+nums[(s/2)-1];
            ans=t/double(2);
        }
        return ans;
    }
};
