'''
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
Explanation:

Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
'''


class Solution:
    def solve(self, board):
        """
        :type board: List[List[str]]
        :rtype: void Do not return anything, modify board in-place instead.
        """
        if not board:
            return None

        m, n = len(board), len(board[0])

        def _solve(i, j):
            if board[i][j] != 'O':
                return
                
            stack = list()
            stack.append((i, j))
            while stack:
                x, y  = stack.pop()
                if board[x][y] != 'O':
                    continue

                board[x][y] = '*'
                directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
                for d in directions:
                    nr = x + d[0]
                    nc = y + d[1]
                    if 0 <= nr < m and 0 <= nc < n:
                        stack.append((nr, nc))

        for i in range(m):
            list(map(_solve, (i, i), (0, n - 1)))

        for i in range(n):
            list(map(_solve, (0, m - 1), (i, i)))

        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O':
                    board[i][j] = 'X'
                elif board[i][j] == '*':
                    board[i][j] = 'O'
