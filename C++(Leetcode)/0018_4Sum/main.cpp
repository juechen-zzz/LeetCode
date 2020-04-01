//
//  main.cpp
//  0018_4Sum   解题思路同15
//
//  Created by 倪浩鹏 on 2020/3/23.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 四数和为0，返回所有组合
 
 Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

 Note:

 The solution set must not contain duplicate quadruplets.

 Example:

 Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

 A solution set is:
 [
   [-1,  0, 0, 1],
   [-2, -1, 1, 2],
   [-2,  0, 0, 2]
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

vector<vector<int>> fourSum(vector<int>& nums, int target) {
    vector<vector<int>> ans;
    if (nums.size() < 4) {return ans;}
    sort(nums.begin(), nums.end());
    int len = (int)nums.size();
    for (int i = 0; i < len - 3; i++) {
        if (i > 0 && nums[i] == nums[i-1]) {continue;}
        for (int j = i + 1; j < len - 2; j++) {
            if (j > i+1 && nums[j] == nums[j-1]) {continue;}
            int l = j + 1;
            int r = len - 1;
            while (l < r) {
                int total = nums[i] + nums[j] + nums[l] + nums[r];
                if (total < target) {l++;}
                else if (total > target) {r--;}
                else {
                    ans.push_back(vector<int> {nums[i], nums[j], nums[l], nums[r]});
                    while (l < r && nums[l] == nums[l + 1]) {l++;}
                    while (l < r && nums[r] == nums[r - 1]) {r--;}
                    l++;
                    r--;
                }
            }
        }
    }
    return ans;
}

int main(int argc, const char * argv[]) {
    int a[] = {1,-2,-5,-4,-3,3,3,5};
    vector<int> ss(a, a + 8);
    PrintVector1(ss);
    
    vector<vector<int>> result;
    result = fourSum(ss, -11);
    PrintVector2(result);
    return 0;
}
