'''
Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
'''

class Solution:
    def isValidSudoku(self, board):
        """
        :type board: List[List[str]]
        :rtype: bool
        """
        col = [{} for _ in range(9)]
        row = [{} for _ in range(9)]
        box = [{} for _ in range(9)]
        for i in range(9):
            for j in range(9):
                n = board[i][j]
                if n != '.':
                    box_index = (i//3) * 3 + j // 3
                    if (n in col[i]) or (n in row[j]) or (n in box[box_index]):
                        return False
                    else:
                        col[i][n] = 1
                        row[j][n] = 1
                        box[box_index][n] = 1
        return True
