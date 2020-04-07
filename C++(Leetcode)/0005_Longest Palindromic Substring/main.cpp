//
//  main.cpp
//  0005_Longest Palindromic Substring
//
//  Created by 倪浩鹏 on 2020/3/16.
//  Copyright © 2020 nihaopeng. All rights reserved.
//  $

/*
 求字符串的最长回文子串
 
 Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

 Example 1:

 Input: "babad"
 Output: "bab"
 Note: "aba" is also a valid answer.
 Example 2:

 Input: "cbbd"
 Output: "bb"
 */

#include <iostream>
using namespace std;

// 函数功能：返回当前字符所能达到的最大回文串长度
int PalindromicSearch(string &s, int toLeft, int toRight)
{
    while(toLeft >= 0 && toRight < s.size() && s[toLeft] == s[toRight])
    {
        --toLeft;
        ++toRight;
    }
    return toRight - toLeft - 1;
}

string longestPalindrome(string s) {
    string ans;
    int max_len = 0;
    int start_index = 0;
    for (int i = 0; i < s.size(); i++) {
        int len1 = PalindromicSearch(s, i, i);          // 回文为单数
        int len2 = PalindromicSearch(s, i, i + 1);      // 回文为双数
        int longer = max(len1, len2);
        
        if (longer > max_len)
        {
            // 定位起始索引
            start_index = i - (longer - 1) / 2;
            max_len = longer;
        }
        // 如果所剩下的长度不足当前最大值的一半，则能够提前终止
        if(s.size() - i < (max_len / 2)){
            break;
        }
    }
    return s.substr(start_index, max_len);
}

int main(int argc, const char * argv[]) {
    string s = "babad";
    cout << longestPalindrome(s) << endl;
    return 0;
}




/*  超时，常规的暴力搜索
 class Solution {
 public:
     string string_reverse(string s){
         string ans;
         for (int i = (int)s.size() - 1; i > -1; i--){
             ans += s[i];
         }
         return ans;
     }
     string longestPalindrome(string s) {
         string temp;
         string ans;
         int max_len = 0;
         for (int i = 0; i < s.size(); i++){
             for (int j = i; j < s.size(); j++){
                 temp = s.substr(i, j-i+1);
                 if (temp == string_reverse(temp) && temp.size() > max_len){
                     max_len = j-i+1;
                     ans.clear();
                     ans = temp;
                 }
             }
         }
         return ans;
     }
 };
 */
