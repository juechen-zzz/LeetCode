//
//  main.cpp
//  0040_Combination Sum II
//
//  Created by 倪浩鹏 on 2020/4/12.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    在一个给定数组中找出所有和为指定值的组合，不允许出现重复的组合，每个值只许用一次
 
 Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

 Each number in candidates may only be used once in the combination.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [10,1,2,7,6,1,5], target = 8,
 A solution set is:
 [
   [1, 7],
   [1, 2, 5],
   [2, 6],
   [1, 1, 6]
 ]
 Example 2:

 Input: candidates = [2,5,2,1,2], target = 5,
 A solution set is:
 [
   [1,2,2],
   [5]
 ]
 */

class Solution {
public:
    // 首先主函数调用回溯，找出所有的组合，再将其中的重复项删除
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> curSet;
        sort(candidates.begin(), candidates.end());
        combinationSum2(candidates, target, 0, 0, curSet, ans);
        DeleteDuplicate(ans);
        return ans;
    }
    
    // 回溯算法
    void combinationSum2(vector<int> &candidates, int target, int idx, int curSum, vector<int> &curSet, vector<vector<int>> &ans){
        if (curSum > target) {return;}
        if (curSum == target){
            ans.push_back(curSet);
            return;
        }
        
        for (int i = idx; i < candidates.size(); i++) {
            curSet.push_back(candidates[i]);
            combinationSum2(candidates, target, i+1, curSum+candidates[i], curSet, ans);
            curSet.pop_back();
        }
    }
    
    // 删除重复的组合
    void DeleteDuplicate(vector<vector<int>> &ans){
        for (vector<vector<int>>::iterator it = ans.begin(); it != ans.end(); it++){
            vector<vector<int>>::iterator right = ans.end()-1;
            while (it != right) {
                if ((*it) == (*right)) {
                    ans.erase(right);
                }
                right--;
            }
        }
    }
};
