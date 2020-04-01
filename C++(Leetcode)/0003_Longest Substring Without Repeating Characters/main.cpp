//
//  main.cpp
//  0003_Longest Substring Without Repeating Characters
//
//  Created by 倪浩鹏 on 2020/3/13.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 求字符串中无重复的最大子串
 
 Given a string, find the length of the longest substring without repeating characters.

 Example 1:

 Input: "abcabcbb"
 Output: 3
 Explanation: The answer is "abc", with the length of 3.
 Example 2:

 Input: "bbbbb"
 Output: 1
 Explanation: The answer is "b", with the length of 1.
 Example 3:

 Input: "pwwkew"
 Output: 3
 Explanation: The answer is "wke", with the length of 3.
              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */




#include <iostream>
using namespace std;

int lengthOfLongestSubstring(string s) {
    int ans = 0;
    int t_ans = 0;
    string temp;
    for (int i = 0; i < s.size(); i++){
        int index_s = (int)temp.find(s[i]);
        if (index_s == -1){
            temp = temp + s[i];
            t_ans++;
        } else{
            temp.erase(0, index_s + 1);
            temp = temp + s[i];
            t_ans = (int)temp.size();
        }
        if (t_ans > ans){
            ans = t_ans;
        }
    }
    return ans;
}

int main(int argc, const char * argv[]){
    string s = "dvdf";
    cout << lengthOfLongestSubstring(s) << endl;
    
}

//class Solution {
//public:
//    int lengthOfLongestSubstring(string s) {
//        vector<int> idx(96, -1);
//        int i = 0, j = 0, l = 0;
//        while(j < s.length()) {
//            if(idx[s[j] - ' '] != -1) {
//                l = max(l, j - i);
//                i = max(i, idx[s[j] - ' '] + 1);
//            }
//            idx[s[j] - ' '] = j;
//            ++j;
//        }
//        return max(l, j - i);
//    }
//};
