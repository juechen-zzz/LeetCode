//
//  main.cpp
//  0077_Combinations
//
//  Created by 倪浩鹏 on 2020/5/11.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 排列组合
 
 Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

 Example:

 Input: n = 4, k = 2
 Output:
 [
   [2,4],
   [3,4],
   [2,3],
   [1,2],
   [1,3],
   [1,4],
 ]
 */


class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<vector<int>> ans;
        vector<int> curr;
        solve(ans,n,k,0,curr,1);
        return ans;
    }
    
    void solve(vector<vector<int>>& ans,int n,int k,int num,vector<int>& curr,int temp) {
        if(num == k) {
            ans.push_back(curr);
        }
        for(int i=temp;i<=n;i++) {
            curr.push_back(i);
            solve(ans,n,k,num+1,curr,i+1);
            curr.pop_back();
        }
    }
};

