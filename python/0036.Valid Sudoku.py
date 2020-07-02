'''
    判断数独是否可行
'''

class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        row = [{} for _ in range(9)]
        col = [{} for _ in range(9)]
        box = [{} for _ in range(9)]
        for i in range(9):
            for j in range(9):
                n = board[i][j]
                if n != '.':
                    box_index = (i // 3) * 3 + j // 3
                    if (n in box[box_index]) or (n in row[i]) or (n in col[j]):
                        return False
                    else:
                        row[i][n] = 1
                        col[j][n] = 1
                        box[box_index][n] = 1
        return True
