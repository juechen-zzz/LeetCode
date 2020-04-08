//
//  main.cpp
//  0033_Search in Rotated Sorted Array
//
//  Created by 倪浩鹏 on 2020/4/8.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 在一个排序并旋转后的数组中找到目标，要求时间复杂度
 
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

 (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

 You are given a target value to search. If found in the array return its index, otherwise return -1.

 You may assume no duplicate exists in the array.

 Your algorithm's runtime complexity must be in the order of O(log n).

 Example 1:

 Input: nums = [4,5,6,7,0,1,2], target = 0
 Output: 4
 Example 2:

 Input: nums = [4,5,6,7,0,1,2], target = 3
 Output: -1
 */

#include <iostream>
#include <vector>
using namespace std;

void PrintVector1(vector<int> &v){
    for (vector<int>::iterator it = v.begin(); it != v.end(); it++) {
        cout << (*it) << " ";
    }
    cout << endl;
}

// 二分查找
int my_binary_search(vector<int>& nums, int target){
    int left = 0;
    int right = (int)nums.size() - 1;
    int ans = -1;
    while (left <= right){
        int mid = (left + right) / 2;
        if (nums[mid] > target){
            right = mid - 1;
        }
        else if(nums[mid] < target){
            left = mid + 1;
        }
        else {
            ans = mid;
            break;
        }
    }
    return ans;
}

// 方案一：先找到旋转点，再排序查找后对齐
int search1(vector<int> &nums, int target){
    int l = 0;
    int r = (int)nums.size() - 1;
    while (l < r){
        int mid = (l + r) / 2;
        if (nums[mid] > nums[r]){
            l = mid + 1;
        }
        else {
            r = mid;
        }
    }
    cout << "l = " << l << endl;
    
    vector<int> num1(nums.begin(), nums.begin() + l);
    //PrintVector1(num1);
    int index = my_binary_search(num1, target);
    if (index == -1) {
        vector<int> num2(nums.begin() + l, nums.end());
        int index2 = my_binary_search(num2, target);
        if (index2 == -1) {
            return -1;
        } else {
            return index2 + l;
        }
    }else {
        return index;
    }
}

int main(int argc, const char * argv[]) {
    int a[] = {4, 5, 6, 7, 0, 1, 2};
    vector<int> num(a, a + 7);
    cout << search1(num, 9) << endl;
    return 0;
}

/*
// 方案二
class Solution {
public:
    int search(vector<int>& nums, int target) {
        if(nums.size() == 0) return -1; // simple corner case
        
        int pivot, l, r, m;
        
        // Pivot is the point where the array is broken
        // It divides the sorted array into separate regions
        // where:   X >= pivot   ||     X < pivot
        
        pivot = nums[0];
        
        // left + right pointers
        l = 0;
        r = nums.size() - 1;
        
        // Since there are two separate regions, we prefer
        // going towards the target (and it's region)
        
        // Regions  |  0 => X < Pivot  | 1 => X >= Pivot |
        int tregion = target >= pivot;
        
        while(l <= r){
            m = (l + r) / 2;
            
            // Obviously
            if(nums[m] == target) return m;
            
            int mregion = nums[m] >= pivot; // region for mid-value
            
            if(! tregion ^ mregion){
                // Both regions are same
                // ( 1 ^ 1 == 0 ^ 0 == 0 )
                // Normal binary search is followed (:|)
                
                if(nums[m] < target) l = m + 1;
                else if(nums[m] > target) r = m - 1;
            }
            else{
                // Else we go towards the region
                if(tregion) r = m - 1;
                else l = m + 1;
            }
        }
        return -1;
    }
};
*/
