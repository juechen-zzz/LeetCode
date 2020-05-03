//
//  main.cpp
//  C++(Leetcode)
//
//  Created by 倪浩鹏 on 2020/3/12.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

#include <iostream>
#include <vector>
using namespace std;

void PrintVector(vector<int> &v){
    for (vector<int>::iterator it = v.begin(); it != v.end(); it++) {
        cout << (*it) << " ";
    }
    cout << endl;
}

void PrintVector2(vector<vector<int>> &v){
    cout << "[" << endl;
    for (int i = 0; i < v.size(); i++) {
        cout << "[";
        for (int j = 0; j < v[i].size(); j++) {
            cout << v[i][j] << " ";
        }
        cout << "]" << endl;
    }
    cout << "]" << endl;
}

void DeleteDuplicate(vector<vector<int>> &ans){
    for (vector<vector<int>>::iterator it = ans.begin(); it != ans.end(); it++){
        vector<vector<int>>::iterator right = ans.end()-1;
        while (it != right) {
            if ((*it) == (*right)) {
                ans.erase(right);
            }
            right--;
        }
    }
}


int main(int argc, const char * argv[]) {
//    int a[] = {1, 1, 6};
//    vector<int> a1(a, a+3);
//    int b[] = {1, 2, 5};
//    vector<int> a2(b, b+3);
//    int c[] = {1, 3, 5};
//    vector<int> a3(c, c+3);
//
//    vector<vector<int>> ans;
//    ans.push_back(a1);
//    ans.push_back(a2);
//    ans.push_back(a1);
//    ans.push_back(a3);
//    PrintVector2(ans);
//
//    DeleteDuplicate(ans);
//    PrintVector2(ans);
//
    
    int fact[10];           // 存放阶乘
    fact[0]=1;
    string s;               // 输出一个"12345"
    for(int i=1;i<=5;i++){
        fact[i]=i*fact[i-1];
        s+= i+'0';
    }
    s.erase(s.begin()+1);
    cout << s << endl;
    return 0;
}
