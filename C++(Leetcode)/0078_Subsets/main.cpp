//
//  main.cpp
//  0078_Subsets
//
//  Created by 倪浩鹏 on 2020/5/11.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 所有子序列
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
