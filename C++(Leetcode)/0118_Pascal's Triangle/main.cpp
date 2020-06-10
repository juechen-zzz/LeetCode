//
//  main.cpp
//  0118_Pascal's Triangle
//
//  Created by 倪浩鹏 on 2020/6/10.
//  Copyright © 2020 nihaopeng. All rights reserved.
//
/*
    杨辉三角
 */

class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> triangle;
        if(numRows <= 0) {return triangle;}
        triangle.push_back({1});
        for(int i=1; i<numRows; i++){
            vector<int> curr = {1};
            vector<int> prev = triangle[i-1];
            for(int j = 0; j < prev.size()-1; j++){
                curr.push_back(prev[j]+prev[j+1]);
            }
            curr.push_back(1);
            triangle.push_back(curr);
        }
        return triangle;
    }
};
