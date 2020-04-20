//
//  main.cpp
//  0049_Group Anagrams
//
//  Created by 倪浩鹏 on 2020/4/20.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 对给的所有字符串分组，按照包含字符相同为一组
 
 Given an array of strings, group anagrams together.

 Example:

 Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Output:
 [
   ["ate","eat","tea"],
   ["nat","tan"],
   ["bat"]
 ]
 */

#include <iostream>

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> vec;
        unordered_map<string, vector<string>> vmap;

        for (int i = 0; i < strs.size(); i++) {
            string str = strs[i];
            string tmp = str;
            // 将字符串排序，然后将排序后的作为map的键
            sort(str.begin(), str.end());
            if (vmap.find(str) == vmap.end()) {
                vector<string> v;
                v.push_back(tmp);
                vmap[str] = v;
            } else {
                vmap[str].push_back(tmp);
            }
        }

        for (unordered_map<string, vector<string>>::iterator it = vmap.begin(); it != vmap.end(); it++) {
            vec.push_back(it->second);
        }

        return vec;
    }
};
