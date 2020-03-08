'''
The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example:

Input: 4
Output: [
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
'''

class Solution:
    def solveNQueens(self, n: int) -> [[str]]:
        def dfs(n, k, c, res):
            if k == 0:
                res += [c]
            else:
                for i in range(n):
                    if not attack(c, i):
                        dfs(n, k - 1, c + [i], res)

        def attack(c, i):
            for r, e in enumerate(c):
                if e == i or len(c) - r == abs(e - i):
                    return True
            return False

        res = []
        dfs(n, n, [], res)

        op = []
        s = '.' * n
        for r in res:
            opr = []
            for e in r:
                opr += [s[:e] + 'Q' + s[e+1:]]
            op += [opr]
        return op