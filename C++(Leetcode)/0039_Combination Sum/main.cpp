//
//  main.cpp
//  0039_Combination Sum
//
//  Created by 倪浩鹏 on 2020/4/11.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    在一个数组中找出和为一个给定值的所有组合，值可重复使用
    回溯
 
 Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

 The same repeated number may be chosen from candidates unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [2,3,6,7], target = 7,
 A solution set is:
 [
   [7],
   [2,2,3]
 ]
 Example 2:

 Input: candidates = [2,3,5], target = 8,
 A solution set is:
 [
   [2,2,2,2],
   [2,3,3],
   [3,5]
 ]
 */

class Solution {
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> ans;
        vector<int> curSet;
        // 利用回溯
        combinationSum(candidates, target, 0, 0, curSet, ans);
        return ans;
    }
    
    void combinationSum(vector<int>& candidates, int target, int idx, int curSum, vector<int>& curSet, vector<vector<int>>& ans) {

        if (curSum > target){return;}           // 当前值本身就大于目标，直接舍弃

        if (curSum == target) {
            ans.push_back(curSet);
            return;
        }

        for (int i = idx; i < candidates.size(); i++) {
            curSet.push_back(candidates[i]);        // 当前组合放入值，然后回溯
            // 回溯的时候还是从索引i开始，这样可以保证值能够重复利用，如果值不能重复利用，则变为i+1(但会存在重复出现一组组合的可能，见40)
            combinationSum(candidates, target, i, curSum+candidates[i], curSet, ans);
            curSet.pop_back();
        }
    }
};
