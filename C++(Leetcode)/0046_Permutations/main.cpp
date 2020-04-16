//
//  main.cpp
//  0046_Permutations
//
//  Created by 倪浩鹏 on 2020/4/16.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    返回所有的排列组合(回溯)
 
 Given a collection of distinct integers, return all possible permutations.

 Example:

 Input: [1,2,3]
 Output:
 [
   [1,2,3],
   [1,3,2],
   [2,1,3],
   [2,3,1],
   [3,1,2],
   [3,2,1]
 ]
 */

#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        length = nums.size();
        vector<bool> state(length, false);
        backtracking(nums, state, 0);

        return res;
    }
private:
    int length = 0;
    vector<vector<int>> res;
    vector<int> cur;

    void backtracking(vector<int> &nums, vector<bool> &state, int index)
    {
        if (index == length)
        {
            res.push_back(cur);
        }
        else
        {
            for (int i = 0; i < nums.size(); i++)
            {
                if (!state[i])
                {
                    state[i] = true;
                    cur.push_back(nums[i]);
                    backtracking(nums, state, index + 1);
                    cur.pop_back();
                    state[i] = false;
                }
            }
        }
    }
};
