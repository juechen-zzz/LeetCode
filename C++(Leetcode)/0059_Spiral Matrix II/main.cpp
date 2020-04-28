//
//  main.cpp
//  0059_Spiral Matrix II
//
//  Created by 倪浩鹏 on 2020/4/28.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

 Example:

 Input: 3
 Output:
 [
  [ 1, 2, 3 ],
  [ 8, 9, 4 ],
  [ 7, 6, 5 ]
 ]
 */

#include <iostream>

class Solution {
public:
  vector<vector<int>> generateMatrix(int n) {
    if (n <= 0) return {};
    vector<vector<int>> dir{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    vector<vector<int>> matrix(n, vector<int>(n, 0));
    int i = 0, j = -1, d = 0, N = n * n, cnt = 0;
    while (cnt < N) {
      int ni = i + dir[d][0], nj = j + dir[d][1];
      while (ni < 0 || ni >= n || nj < 0 || nj >= n || matrix[ni][nj] != 0) {
        d = (d + 1) % 4;
        ni = i + dir[d][0];
        nj = j + dir[d][1];
      }
      i = ni;
      j = nj;
      matrix[i][j] = ++cnt;
    }
    return matrix;
  }
};

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    return 0;
}
