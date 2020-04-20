//
//  main.cpp
//  0047_Permutations II
//
//  Created by 倪浩鹏 on 2020/4/16.
//  Copyright © 2020 nihaopeng. All rights reserved.
// https://leetcode.com/problems/permutations-ii/discuss/562948/C%2B%2B-backtracking-24ms-with-explainations-about-remove-duplicates

There is difference between "Combination/Subset" and "Permutation".
For example:[1,2,3], Combination only has [1,2,3]. Permutations includes[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1].


1.Combination Sum
Because it is combination, so [1,2,3] and [3,2,1] are duplicates.
If we take [1,5,2,3] as an example, when we iterate to index 2 where value is 2, it makes no sense to start before index 2, because [1,5,2] and [2,1,5] are the same.
That's the meaning i_start(or begin) has, and this begin may make sense in other questions, we should keep it in mind.

class Solution {
private:
    vector<vector<int>> _res;
    void DFS(const vector<int>& candidates, vector<int>& combination, int target, int i_start){
        if(target == 0){
            _res.push_back(combination);
            return;
        }
        for (int i = i_start; i < candidates.size();++i){//i_start is important to remove duplicates under the situation
            if(target - candidates[i] >= 0){
                combination.push_back(candidates[i]);
                DFS(candidates, combination, target - candidates[i], i);
                combination.pop_back();
            }
        }
    }

public:
    vector<vector<int>> combinationSum(const vector<int>& candidates, int target) {
        vector<int> combination;
        DFS(candidates, combination, target,0);
        return _res;
    }
};


2.Combination Sum II
What about the duplicates caused from the duplicate numbers in input?
We sort them first. and then take 1122333 as an example.
If we meet 11, we will have these choice at this level(or layer or depth).
11
2 || 2 || 3 || 3 || 3
Apparently, the second 2 and the 2nd & 3rd 3 will induce duplicate solutions, because we use DFS and these solutions have been computed in the path 112(first '2') or 113(first'3').

↓If we choose first 2,                          ↓If we choose second 2,
      112                                                  112
2 || 3 || 3 || 3                                        3 || 3 || 3
That's why num[i]==num[i-1].
So why i>begin?
If we go further, we will meet 112, we will have these choice at this level.
112
2 || 3 || 3 || 3
Surely, we are not willing to skip the first2at beginning of this level.
That's why i>begin.
So we use i>begin && num[i]==num[i-1].
In short, to remove the second part duplicates, we have to sort the array first, and then skip the same value at each level.

class Solution {
private:
    vector<vector<int>> _res;
    void DFS(const vector<int>& candidates, vector<int>& cur, int target, int begin){
        if(target == 0)
            _res.push_back(cur);
        for (int i = begin; i < candidates.size();++i){//begin is to remove first part of duplicates, which plays the same role in problem Combination Sum.
            if(i > begin && candidates[i] == candidates[i-1])//this means to remove the second part of duplicates.
                continue;
            if(target - candidates[i] >= 0){
                cur.push_back(candidates[i]);
                DFS(candidates, cur, target - candidates[i], i + 1);
                cur.pop_back();
            }
        }
    }
public:
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());//this helps to remove the second part of duplicates
        vector<int> cur;
        DFS(candidates, cur, target, 0);
        return _res;
    }
};


3.Permutations
Under this question, [1,2,3] and [3,2,1] are different.
So we have to iterate from 0 in each iteration rather than start from begin.
What about numbers we have used? We can mark them like array visited in BFS.
If we have used it, we should skip it. And we should keep this in mind.

class Solution {
private:
    vector<vector<int>> _res;
    vector<bool> _visited;
    void DFS(const vector<int>& nums, vector<int>& cur){
        if(cur.size()==nums.size()){
            _res.push_back(cur);
            return;
        }
        for (int i = 0; i < nums.size();++i){//because of it is permutation, we have to start from 0 in each iteration
            if(!_visited[i]){//the visited array
                _visited[i] = true;
                cur.push_back(nums[i]);
                DFS(nums, cur);
                cur.pop_back();
                _visited[i] = false;
            }
        }
    }
public:
    vector<vector<int>> permute(vector<int>& nums) {
        _visited.resize(nums.size(), false);
        vector<int> cur;
        DFS(nums, cur);
        return _res;
    }
};


4.Permutations II
Now, it is time to talk about this problem.
You can find both some similarities and some difference bettwen Combination Sum with Permutations, Combination Sum II with Permutations II.
It is difficult for me to put it clear in English, but I wish you can find the similarities and difference.
As we make use of the solution to Combination Sum in Combination Sum II, we also can make use of the array visited in Permutations.
And we just need to skip same value at each level(or layer or depth), what should we do?
Because it is problem about permutation, so we have to iterate from 0, resulting in using array visited.
The level should include every number in array nums which has not been visited.
And like what we do in Combination Sum II, we skip same value at each level to remove duplicates.
We have to iterate from 0, so i-1>=0, --> i>0.
So we use (i && !_visited[i-1] && nums[i]==nums[i-1]).
Why !_visited[i-1]? If nums[i-1]has been visited, it is not the value at this level.
Solution:

class Solution {
private:
    vector<vector<int>> _res;
    vector<bool> _visited;
    void DFS(const vector<int>& nums, vector<int>& cur){
        if(cur.size()==nums.size()){
            _res.push_back(cur);
            return;
        }
        for (int i = 0; i < nums.size();++i){//because it is a problem about permutation, we have to iterate from 0.
            if(_visited[i])//1st step to remove duplicates
                continue;
            if(i && !_visited[i-1] && nums[i]==nums[i-1])//2nd step to remove duplicates
                continue;
            _visited[i] = true;
            cur.push_back(nums[i]);
            DFS(nums, cur);
            cur.pop_back();
            _visited[i] = false;
        }
    }
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
        sort(nums.begin(), nums.end());//help to remove duplicates
        _visited.resize(nums.size(), false);
        vector<int> cur;
        DFS(nums, cur);
        return _res;
    }
};
