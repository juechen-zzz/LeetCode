//
//  main.cpp
//  0078_Subsets
//
//  Created by 倪浩鹏 on 2020/5/11.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 所有子序列
 
 Given a set of distinct integers, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: nums = [1,2,3]
 Output:
 [
   [3],
   [1],
   [2],
   [1,2,3],
   [1,3],
   [2,3],
   [1,2],
   []
 ]
 */

class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> res;
        vector<int> temp;
        backtrack(nums, 0, temp, res);
        return res;
    }
    
    void backtrack(vector<int>& nums, int idx, vector<int>&build_subset, vector<vector<int>>& subsets) {
        subsets.push_back(build_subset);
        for (int i = idx; i < nums.size(); i++) {
            build_subset.push_back(nums[i]);
            backtrack(nums, i+1, build_subset, subsets);
            build_subset.pop_back();
        }
    }
};
