//
//  main.cpp
//  0022_Generate Parentheses
//
//  Created by 倪浩鹏 on 2020/3/25.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 DFS问题：用走迷宫的思路，相当于先走，如果此路不通，则回退到上一步再走
 
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
   "((()))",
   "(()())",
   "(())()",
   "()(())",
   "()()()"
 ]
 */

#include <iostream>
#include <vector>
using namespace std;

vector<string> res;

void dfs(string s, int left, int right){
    if (left < right) {
        return;
    }
    if (left == 0 && right == 0) {
        res.push_back(s);
    }
    if (left > 0) {
        dfs(s + "(", left - 1, right);
    }
    if (right > 0) {
        dfs(s + ")", left, right - 1);
    }
}

vector<string> generateParenthesis(int n) {
    res.clear();
    dfs("", n, n);
    return res;
}
