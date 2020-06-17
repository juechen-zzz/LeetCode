//
//  main.cpp
//  0132_Palindrome Partitioning II
//
//  Created by 倪浩鹏 on 2020/6/17.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    给定字符串，将之分解为所有子串都回文，最少要几次切割
 */


// 超时
class Solution {
public:
    vector<vector<string>> out;
    
    bool isPalindrome(string s)
    {
        for(int i = 0; i < s.size()/2; i++)
        {
            if(s[i] != s[s.size()-1-i]) return false;
        }
        return true;
    }
    
    void helper(string s, vector<string> v)
    {
        if(s == "") {out.push_back(v);}
        
        for(int i = 0; i < s.size(); i++)
        {
            string sub = s.substr(0, i+1);
            if(isPalindrome(sub))
            {
                v.push_back(sub);
                helper(s.substr(i+1, s.size()-i-1), v);
                v.pop_back();
            }
        }
    }
    
    int minCut(string s) {
        vector<string> v;
        helper(s, v);
        int ans = INT_MAX;
        for (int i = 0; i < out.size(); i++){
            if (out[i].size() < ans) {
                ans = out[i].size();
            }
        }
        return (ans-1);
    }
};

// 参考
// 1、输入字符串s[i]==s[j],对称性；
// 2、条件1满足并不能保证i到j构成回文，还须：（j-i）<=1或者DP[i+1][j-1]=1；
// 即，i、j相邻或者i=j，也就是相邻字符相等构成回文或者字符自身构成回文，
// 如果i、j不相邻或者相等，i到j构成回文的前提就是DP[i+1][j-1]=1.
class Solution {
public:
    int minCut(string s)
    {
        vector<vector<int>> dp;
        vector<int> temp;
        temp.resize(s.size(), 0);
        dp.resize(s.size(), temp);
    
        vector<int> cut(s.size()+1,0);
        
        for(int i=s.size()-1;i>=0;i--)
        {
            cut[i]=INT_MAX;
            for(int j=i;j<s.size();j++)
            {
                if(s.at(i)==s.at(j)&&(j-i<=1||dp[i+1][j-1]==1))
                {
                    dp[i][j]=1;
                    // 用一个一维数组来存储分割次数：cut[i]表示第i个字符到最后一个字符所构成的子串的最小分割次数
                    cut[i]=min(1+cut[j+1],cut[i]);
                }
            }
        }
        return cut[0]-1;
    }
};
