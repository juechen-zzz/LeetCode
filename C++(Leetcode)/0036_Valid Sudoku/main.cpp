//
//  main.cpp
//  0036_Valid Sudoku
//
//  Created by 倪浩鹏 on 2020/4/10.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    验证数独是否有效，无重复即可
 
 Example 1:

 Input:
 [
   ["5","3",".",".","7",".",".",".","."],
   ["6",".",".","1","9","5",".",".","."],
   [".","9","8",".",".",".",".","6","."],
   ["8",".",".",".","6",".",".",".","3"],
   ["4",".",".","8",".","3",".",".","1"],
   ["7",".",".",".","2",".",".",".","6"],
   [".","6",".",".",".",".","2","8","."],
   [".",".",".","4","1","9",".",".","5"],
   [".",".",".",".","8",".",".","7","9"]
 ]
 Output: true
 Example 2:

 Input:
 [
   ["8","3",".",".","7",".",".",".","."],
   ["6",".",".","1","9","5",".",".","."],
   [".","9","8",".",".",".",".","6","."],
   ["8",".",".",".","6",".",".",".","3"],
   ["4",".",".","8",".","3",".",".","1"],
   ["7",".",".",".","2",".",".",".","6"],
   [".","6",".",".",".",".","2","8","."],
   [".",".",".","4","1","9",".",".","5"],
   [".",".",".",".","8",".",".","7","9"]
 ]
 Output: false
 Explanation: Same as Example 1, except with the 5 in the top left corner being
     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 */

class Solution {
public:
    bool isValidSudoku(vector<vector<char>>& board) {
        // 创建三个二维数组，初始值都为0
        vector<vector<int>> row (9, vector<int>(9,0));
        vector<vector<int>> col (9, vector<int>(9,0));
        vector<vector<int>> box (9, vector<int>(9,0));

        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    continue;
                }
                // 当前单元格的值
                int val = board[i][j] - '1';
                // 子数独的索引
                int box_index = (i/3) * 3 + j/3;
                
                if(row[i][val] == 0 && col[j][val] == 0 && box[box_index][val] == 0){
                    row[i][val] = 1;
                    col[j][val] = 1;
                    box[box_index][val] = 1;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
};
