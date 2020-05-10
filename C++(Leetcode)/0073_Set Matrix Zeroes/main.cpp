//
//  main.cpp
//  0073_Set Matrix Zeroes
//
//  Created by 倪浩鹏 on 2020/5/11.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 数组将0出现的行列都变成0
 
 Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

 Example 1:

 Input:
 [
   [1,1,1],
   [1,0,1],
   [1,1,1]
 ]
 Output:
 [
   [1,0,1],
   [0,0,0],
   [1,0,1]
 ]
 Example 2:

 Input:
 [
   [0,1,2,0],
   [3,4,5,2],
   [1,3,1,5]
 ]
 Output:
 [
   [0,0,0,0],
   [0,4,5,0],
   [0,3,1,0]
 ]
 */

class Solution {
public:
    void setZeroes(vector<vector<int>>& grid) {
        set<int> zero_rows, zero_cols;
        int n = grid.size();
        int m = grid[0].size();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    zero_rows.insert(i);
                    zero_cols.insert(j);
                }
            }
        }
        for (auto row:zero_rows)
            for (int j = 0; j < m; j++)
                grid[row][j] = 0;
                
        for (auto col:zero_cols)
            for (int j = 0; j < n; j++)
                grid[j][col] = 0;
    }
};
