//
//  main.cpp
//  0014_Longest Common Prefix
//
//  Created by 倪浩鹏 on 2020/3/19.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    Write a function to find the longest common prefix string amongst an array of strings.

    If there is no common prefix, return an empty string "".

    Example 1:

    Input: ["flower","flow","flight"]
    Output: "fl"
    Example 2:

    Input: ["dog","racecar","car"]
    Output: ""
    Explanation: There is no common prefix among the input strings.
    Note:

    All given inputs are in lowercase letters a-z.
 */

#include <iostream>
#include <vector>
using namespace std;


string longestCommonPrefix(vector<string>& strs) {
    if (strs.empty()) {return "";}
    string prefix = strs[0];
    for (vector<string>::iterator it = strs.begin() + 1; it != strs.end(); it++) {
        // 防止第一个字符串为空串，或者第一个字符串和后面的完全不匹配，导致被删光
        while (prefix != "") {
            // 如果能在(*it)中找到prefix的索引为0，则结束while循环；否则prefix删除最后一个字符
            if (it->find(prefix) == 0)
                break;
            else
                prefix.pop_back();
        }
        if (prefix == "")
            return prefix;
    }
    return prefix;
}


int main(int argc, const char * argv[]) {
    string a[] = {"flower","flow","flight"};
    vector<string> s(a, a + 3);
    cout << longestCommonPrefix(s) << endl;
    return 0;
}
