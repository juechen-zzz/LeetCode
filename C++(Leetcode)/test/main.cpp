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
}

int main(int argc, const char * argv[]) {
    vector<int> idx(96, -1);
    PrintVector(idx);
    string s = " ";
    if (s[0] >= 32) {
        cout << "123";
    }
    return 0;
}
