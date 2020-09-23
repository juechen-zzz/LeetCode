"""
Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Example:

X X X X
X O O X
X X O X
X O X X
After running your function, the board should be:

X X X X
X X X X
X X X X
X O X X
"""

class Solution:
    def __init__(self):
        self.d = [[-1, 0], [0, 1], [1, 0], [0, -1]]
        
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        if len(board) == 0 or len(board[0]) == 0: return
        if len(board) == 1 or len(board[0]) == 1: return board
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if (i == 0 or i == len(board)-1 or j == 0 or j == len(board[0])-1) and board[i][j] == 'O':
                    self.DFS(i, j, board)
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] != '.': board[i][j] = 'X'
                else: board[i][j] = 'O'
    
    def DFS(self, x, y, board):
        board[x][y] = '.'
        for i in range(4):
            next_x, next_y = x + self.d[i][0], y + self.d[i][1]
            if next_x >= 0 and next_x < len(board) and next_y >= 0 and next_y < len(board[0]) and board[next_x][next_y] == 'O':
                self.DFS(next_x, next_y, board)
        