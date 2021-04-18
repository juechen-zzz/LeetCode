/* 
给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。

示例 1：

输入: m = 2, n = 2, N = 2, i = 0, j = 0
输出: 6

示例 2：

输入: m = 1, n = 3, N = 3, i = 0, j = 1
输出: 12

 */

// DFS 超时
class Solution {
    int res = 0;
    public int findPaths(int m, int n, int N, int i, int j) {
        dfs(m, n, N, i, j);
        return res;
    }
    public void dfs(int m, int n, int N, int i, int j){
        if(N == 0 && i >= 0 && i < m && j >= 0 && j < n) return;
        if(i >= N && m - i > N && j >= N && n - j > N) return;
        if(N >= 0 && (i == -1 || j == -1 || i == m || j == n)){
            res = (res + 1) % 1000000007;
            return;
        }
        dfs(m, n, N - 1, i + 1, j);
        dfs(m, n, N - 1, i - 1, j);
        dfs(m, n, N - 1, i, j + 1);
        dfs(m, n, N - 1, i, j - 1);
    }
}

// DP
class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        if (N == 0) {return 0;}
        long[][][] dp = new long[m + 2][n + 2][N + 1];

        for (int r = 0; r <= m + 1; r++) {
            dp[r][0][0] = 1;
            dp[r][n + 1][0] = 1;
        }
        for (int c = 0; c <= n + 1; c++) {
            dp[0][c][0] = 1;
            dp[m + 1][c][0] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int r = 1; r <= m; r++) {
                for (int c = 1; c <= n; c++) {
                    dp[r][c][k] = (dp[r - 1][c][k - 1] + dp[r + 1][c][k - 1] + dp[r][c - 1][k - 1] + dp[r][c + 1][k - 1]) % 1000000007;
                }
            }
        }

        int ans = 0;
        for (int k = 1; k <= N; k++) {
            ans = (int)((ans + dp[i + 1][j + 1][k]) % 1000000007);
        }
        return ans;
    }
}
