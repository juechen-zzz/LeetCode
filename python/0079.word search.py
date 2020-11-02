"""
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where "adjacent" cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
"""


class Solution:
    def exist(self, board: List[List[str]], word: str) -> bool:
        
        def DFS(index, row, col):
            if row < 0 or row > len(board)-1 or col < 0 or col > len(board[0])-1: return False
            if word[index] == board[row][col]:
                board[row][col] = '0'
                if index == len(word)-1 or DFS(index+1, row+1, col) or DFS(index+1, row-1, col) or DFS(index+1, row, col+1) or DFS(index+1, row, col-1): return True
                board[row][col] = word[index]
            return False
        
        for i in range(len(board)):
            for j in range(len(board[0])):
                if board[i][j] == word[0]:
                    if DFS(0, i, j): return True
        return False