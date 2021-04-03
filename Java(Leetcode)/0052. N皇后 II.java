/* 
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。

给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。


示例 1：
输入：n = 4
输出：2
解释：如上图所示，4 皇后问题存在两个不同的解法。
示例 2：

输入：n = 1
输出：1

 */

class Solution {
    int res = 0;

    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] i : board) {
            Arrays.fill(i, '.');
        }
        backtrack(board, 0);
        return res;
    }

    public void backtrack(char[][] board, int row) {
        if (row == board.length) {
            res++;
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (!check(board, row, col)) {continue;}
            board[row][col] = 'Q';
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    public List<String> array2list(char[][] board) {
        List<String> res = new ArrayList<>();
        for (char[] i : board) {
            StringBuilder s = new StringBuilder();
            for (char j : i) {
                s.append(j);
            }
            res.add(s.toString());
        }
        return res;
    }

    public boolean check(char[][] board, int row, int col) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }
        return true;
    }
}