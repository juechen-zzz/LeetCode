//
//  main.cpp
//  0054_Spiral Matrix
//
//  Created by 倪浩鹏 on 2020/4/24.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 旋转输出一个矩阵
 
 Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

 Example 1:

 Input:
 [
  [ 1, 2, 3 ],
  [ 4, 5, 6 ],
  [ 7, 8, 9 ]
 ]
 Output: [1,2,3,6,9,8,7,4,5]
 Example 2:

 Input:
 [
   [1, 2, 3, 4],
   [5, 6, 7, 8],
   [9,10,11,12]
 ]
 Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

#include <iostream>
#include <vector>
using namespace std;

vector<int> spiralOrder(vector<vector<int>>& matrix) {
    vector<int> res;
    if (matrix.size()==0){return res;}
    int top = 0;
    int bottom = (int)matrix.size() - 1;
    int left = 0;
    int right = (int)matrix[0].size() - 1;
    while (top < bottom && left < right){
        for (int i = left; i <= right; i++){
            res.push_back(matrix[top][i]);
        }
        for (int i = top+1; i < bottom; i++){
            res.push_back(matrix[i][right]);
        }
        for (int i = right; i >= left; i--){
            res.push_back(matrix[bottom][i]);
        }
        for (int i = bottom-1; i > top; i--){
            res.push_back(matrix[i][left]);
        }
        top++;
        left++;
        right--;
        bottom--;
    }
    
    if (top == bottom){
        for (int i = left; i <= right; i++){
            res.push_back(matrix[top][i]);
        }
    } else if (left == right){
        for (int i = top; i <= bottom; i++){
            res.push_back(matrix[i][right]);
        }
    }
    return res;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
