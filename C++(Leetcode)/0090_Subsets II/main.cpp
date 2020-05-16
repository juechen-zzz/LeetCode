//
//  main.cpp
//  0090_Subsets II
//
//  Created by 倪浩鹏 on 2020/5/16.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: [1,2,2]
 Output:
 [
   [2],
   [1],
   [1,2,2],
   [2,2],
   [1,2],
   []
 ]
 */


class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        set<vector<int>> V;
        // 1<<nums.size()指的是所有组合数
        for (int i=0; i<(1<<nums.size()); ++i) {
            vector<int> v;
            // i>>j & 1 先右移再按位与1
            for (int j=0; j<nums.size(); ++j) if (i>>j & 1) v.push_back(nums[j]);
            sort(v.begin(),v.end());
            V.insert(v);
        }
        return vector<vector<int>>(V.begin(),V.end());
    }
};
