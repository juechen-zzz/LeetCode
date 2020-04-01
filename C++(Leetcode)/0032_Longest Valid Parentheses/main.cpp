//
//  main.cpp
//  0032_Longest Valid Parentheses
//
//  Created by 倪浩鹏 on 2020/4/2.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 返回字符串中能括号组合成对的最大子串长度
 动态规划问题
 
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 Example 1:

 Input: "(()"
 Output: 2
 Explanation: The longest valid parentheses substring is "()"
 Example 2:

 Input: ")()())"
 Output: 4
 Explanation: The longest valid parentheses substring is "()()"
 */

#include <iostream>
#include <vector>
using namespace std;

int longestValidParentheses(string s) {
    int ret = 0;
    // 创建全0的动态数组，存放当前字符时符合要求的最大长度
    vector<int> dp(s.length() + 1);
    for (int i = 1; i < s.length(); ++i) {
        int j = i - dp[i] - 1;
        if (s[i] == ')' && j >= 0 && s[j] == '(')
            dp[i + 1] = dp[i] + dp[j] + 2;
        ret = max(ret, dp[i + 1]);
    }
    return ret;
}

int main(int argc, const char * argv[]) {
    string s = "(()";
    cout << longestValidParentheses(s) << endl;
    return 0;
}
