//
//  main.cpp
//  0015_3Sum
//
//  Created by 倪浩鹏 on 2020/3/20.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 三数和为0，返回三个数的数组
 
 Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note:

 The solution set must not contain duplicate triplets.

 Example:

 Given array nums = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
   [-1, 0, 1],
   [-1, -1, 2]
 ]
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

void PrintVector2(vector<vector<int>> &v){
    cout << "[" << endl;
    for (int i = 0; i < v.size(); i++) {
        cout << "[";
        for (int j = 0; j < v[i].size(); j++) {
            cout << v[i][j] << " ";
        }
        cout << "]" << endl;
    }
    cout << "]" << endl;
}



vector<vector<int>> threeSum(vector<int>& nums){
    vector<vector<int>> ans;
    // 元素个数小于3直接返回空
    if (nums.size() < 3) {return ans;}
    sort(nums.begin(), nums.end());
    int len = (int)nums.size();
    
    for (int i = 0; i < len - 2; i++) {
        if (nums[i] > 0) {break;}
        // 排除会出现完全相同的组合可能[-1, -1, 0, 1]这种，把第二个-1跳过
        if (i > 0 && nums[i] == nums[i-1]) {continue;}
        
        int l = i + 1;
        int r = len - 1;
        // 左右同时往中间靠
        while (l < r) {
            int total = nums[i] + nums[l] + nums[r];
            if (total < 0) {l++;}
            else if (total > 0) {r--;}
            else {
                ans.push_back(vector<int> {nums[i], nums[l], nums[r]});
                // 左右出现重复值的时候就向中间移一位
                while (l < r && nums[l] == nums[l + 1]) {l++;}
                while (l < r && nums[r] == nums[r - 1]) {r--;}
                l++;
                r--;
            }
        }
    }
    return ans;
}


int main(int argc, const char * argv[]) {
    int s[] = {-1, 0, 1, 2, -1, -4};
    vector<int> ss(s, s + 6);
    vector<vector<int>> result1;
    result1 = threeSum(ss);
    PrintVector2(result1);
    return 0;
}
