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
    int n = 5;
    cout << (1<<n) << endl;
    cout << (0 & 1) << endl;
    return 0;
}
