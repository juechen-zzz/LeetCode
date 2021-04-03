/* 
给定一个 m x n 整数矩阵 matrix ，找出其中 最长递增路径 的长度。

对于每个单元格，你可以往上，下，左，右四个方向移动。 你 不能 在 对角线 方向上移动或移动到 边界外（即不允许环绕）。

示例 1：
输入：matrix = [[9,9,4],[6,6,8],[2,1,1]]
输出：4 
解释：最长递增路径为 [1, 2, 6, 9]。

 */

// 直接DFS会超时，需要用一个visited矩阵来记录是否访问过，并写入从这个点出发的最大递升距离
class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) {return 0;}
        int[][] visited = new int[matrix.length][matrix[0].length];
        int ans = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (visited[i][j] == 0) {
                    ans = Math.max(ans, dfs(matrix, visited, i, j));
                }
            }
        }

        return ans;
    }

    private int dfs(int[][] matrix, int[][] visited, int row, int col) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length) {return 0;}
        if (visited[row][col] > 0) {return visited[row][col];}

        int ans = 0;
        if (row - 1 >= 0 && matrix[row - 1][col] > matrix[row][col]) {
            ans = Math.max(ans, dfs(matrix, visited, row - 1, col));
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] > matrix[row][col]) {
            ans = Math.max(ans, dfs(matrix, visited, row + 1, col));
        }
        if (col - 1 >= 0 && matrix[row][col - 1] > matrix[row][col]) {
            ans = Math.max(ans, dfs(matrix, visited, row, col - 1));
        }
        if (col + 1 < matrix[0].length && matrix[row][col + 1] > matrix[row][col]) {
            ans = Math.max(ans, dfs(matrix, visited, row, col + 1));
        }

        visited[row][col] = ans + 1;
        return ans + 1;
    }
}
