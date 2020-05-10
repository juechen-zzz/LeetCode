//
//  main.cpp
//  0074_Search a 2D Matrix
//
//  Created by 倪浩鹏 on 2020/5/11.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 二维数组查找（已排序）
 
 Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.
 Example 1:

 Input:
 matrix = [
   [1,   3,  5,  7],
   [10, 11, 16, 20],
   [23, 30, 34, 50]
 ]
 target = 3
 Output: true
 Example 2:

 Input:
 matrix = [
   [1,   3,  5,  7],
   [10, 11, 16, 20],
   [23, 30, 34, 50]
 ]
 target = 13
 Output: false
 */

// 简单解法
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.size() == 0 || matrix[0].size() == 0) {return false;}
        int m = matrix.size();
        int n = matrix[0].size();
        for (int i = 0; i < m; i++){
            if (matrix[i][0] > target) {continue;}
            for (int j = 0; j < n; j++){
                if (matrix[i][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
};

// 二分查找
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        if (matrix.empty()) return false;
        int i=0, j=matrix.size()*matrix[0].size()-1, mid, rmid, cmid;
        while (i<=j){
            mid = (i+j)/2;                  // 中位数
            rmid = mid/matrix[0].size();    // 中位数所在行
            cmid = mid%matrix[0].size();    // 中位数所在列
            if (matrix[rmid][cmid]==target){
                return true;
            }else if (matrix[rmid][cmid]>target){
                j = mid-1;
            }else{
                i = mid+1;
            }
        }
        return false;
    }
};
