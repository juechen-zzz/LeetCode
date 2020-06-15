//
//  main.cpp
//  0131_Palindrome Partitioning
//
//  Created by 倪浩鹏 on 2020/6/15.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    给定字符串，将之分解为所有子串都回文的所有可能
 */

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
    
    vector<vector<string>> partition(string s) {
        vector<string> v;
        helper(s, v);
        return out;
    }
};
