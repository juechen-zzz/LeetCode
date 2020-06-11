//
//  main.cpp
//  0119_Pascal's Triangle II
//
//  Created by 倪浩鹏 on 2020/6/11.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    杨辉三角，返回指定行
 */

class Solution {
public:
    vector<int> getRow(int rowIndex) {
        vector<vector<int>> triangle;
        triangle.push_back({1});
        if (rowIndex == 0) {return triangle[0];}
        for (int i = 1; i < (rowIndex+1); i++){
            vector<int> curr = {1};
            vector<int> prev = triangle[i-1];
            for (int j = 0; j < prev.size()-1; j++){
                curr.push_back(prev[j]+prev[j+1]);
            }
            curr.push_back(1);
            triangle.push_back(curr);
        }
        return triangle[rowIndex];
    }
};
