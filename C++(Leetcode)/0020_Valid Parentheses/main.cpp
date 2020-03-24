//
//  main.cpp
//  0020_Valid Parentheses
//
//  Created by 倪浩鹏 on 2020/3/24.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

#include <iostream>
#include <map>
#include <stack>
using namespace std;

void PrintMap(map<char, char> &m){
    for (map<char, char>::iterator it = m.begin(); it != m.end(); it++) {
        cout << (*it).first << "-" << (*it).second << " ";          // it->first也可
    }
    cout << endl;
}

void PrintStack(stack<char> &s){
    while (!s.empty()) {    // 判定是否为空，再取反
        cout << s.top() << " ";
        s.pop();
    }
    cout << endl;
}

bool isValid(string s) {
    if (s.size() % 2 == 1) {return false;}
    stack<char> ans;
    // 构造键值对，键为)，值为(
    map<char, char> dict;
    dict.insert(make_pair(')', '('));
    dict.insert(make_pair('}', '{'));
    dict.insert(make_pair(']', '['));
    
    for(int i = 0; i < s.size(); i++){
        // 如果查找到左括号，则放入堆栈
        for (map<char, char>::iterator it = dict.begin(); it != dict.end(); it++) {
            if (it->second == s[i]) {
                ans.push(s[i]);
                break;
            }
        }
        // 如果判定为左括号，直接跳过
        if (!dict.count(s[i])) {
            continue;
        }
        // 判定为右括号，若此时堆栈为空，或者此时堆栈最上方的值不等于对应的左括号
        else if (ans.empty() || (dict.find(s[i]))->second != ans.top()){
            return false;
        }
        // 判定为有括号，并且与左值成功匹配，则删除栈顶元素
        else {
            ans.pop();
        }
    }
//    PrintMap(dict);
//    PrintStack(ans);
    return (ans.empty());
}

int main(int argc, const char * argv[]) {
    string s = "(){}[]";
    cout << isValid(s) << endl;
    return 0;
}
