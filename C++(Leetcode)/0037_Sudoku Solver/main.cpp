//
//  main.cpp
//  0037_Sudoku Solver
//
//  Created by 倪浩鹏 on 2020/4/10.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
解数独：
    就是对每一个空着的格子穷举 1 到 9，如果遇到不合法的数字
    （在同一行或同一列或同一个 3×3 的区域中存在相同的数字）则跳过，如果找到一个合法的数字，则继续穷举下一个空格子

 */



class Solution {
public:
    // 判定是否为有效数独
    bool isValidSudoku(vector<vector<char>>& board, char rows[][9], char cols[][9], char boxs[][9]) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int n = (int)(board[i][j] - '1');
                int b = (i / 3 ) * 3 + j / 3;

                if (rows[i][n] || cols[j][n] || boxs[b][n]) {
                    return false;
                }
                rows[i][n] = 1;
                cols[j][n] = 1;
                boxs[b][n] = 1;
            }
        }
        return true;
    }

    // 用回溯法解决问题
    void solveSudoku(vector<vector<char>>& board) {
        char rows[9][9] = {0};
        char cols[9][9] = {0};
        char boxs[9][9] = {0};
        if (!isValidSudoku(board, rows, cols, boxs)) {
            return;
        }
        backtrance(0, 0, 0, board, rows, cols, boxs);
    }

    // 回溯
    bool backtrance(int i, int j, int count, vector<vector<char>>& board, char rows[][9], char cols[][9], char boxs[][9]) {
        if (count >= 81) {                                  // 记录已经填了多少数字
            return true;
        }
        
        while (i < 9 && j < 9 && board[i][j] != '.') {      // 跳过本来已经存在的数字
            count ++;
            j ++;
            if (9 == j) {
                i ++;
                j = 0;
            }
        }

        if (count >= 81) {                                   // 特殊情况，题目本身就是一个完全体的时候
            return true;
        }

        int b = (i / 3 ) * 3 + j / 3;                        // 当前小数独块索引
        
        for (int n = 8; n >= 0; n--) {
            if (rows[i][n] || cols[j][n] || boxs[b][n]) {    // 当前单元格不能放入数字n的情况
                continue;
            }

            board[i][j] = '1' + n;
            rows[i][n] = 1;
            cols[j][n] = 1;
            boxs[b][n] = 1;

            count ++;                                       // 放入n后，跳到下一个单元格
            
            int ni = i;
            int nj = j;
            nj ++;
            if (9 == nj) {
                ni ++;
                nj = 0;
            }

            if (backtrance(ni, nj, count, board, rows, cols, boxs)) {       // 回溯
                return true;
            }
            
            count --;                                       // 当前放入后不满足条件后调整
            board[i][j] = '.';
            rows[i][n] = 0;
            cols[j][n] = 0;
            boxs[b][n] = 0;
        }

        return false;
    }
};
