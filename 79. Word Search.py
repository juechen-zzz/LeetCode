'''
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
'''


class Solution:
    def DFS(self, board, i, j , word, m, n, seen):
        seen.add((i,j))
        if board[i][j] != word[0]:
            return False
        if not word[1:]:
            return True
        for (u, v) in ((i-1, j), (i+1, j), (i, j-1), (i, j+1)):
            if 0<=u<m and 0<=v<n and (u, v) not in seen:
                if self.DFS(board, u, v, word[1:], m, n, seen):
                    return True
                else:
                    seen.remove((u,v))
        return False
    
 
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        m, n = len(board), len(board[0])
 
        for i in range(m):
            for j in range(n):
                if self.DFS(board, i, j , word, m, n, set()):
                    return True
    
        return False