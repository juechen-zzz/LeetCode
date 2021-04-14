/* 
给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。

两个相邻元素间的距离为 1 。

示例 1：

输入：
[[0,0,0],
 [0,1,0],
 [0,0,0]]

输出：
[[0,0,0],
 [0,1,0],
 [0,0,0]]

 */

class Solution {
    private static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int[][] updateMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] ans = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int d = 0; d < 4; d++) {
                int nextX = x + dirs[d][0];
                int nextY = y + dirs[d][1];
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && !visited[nextX][nextY]) {
                    ans[nextX][nextY] = ans[x][y] + 1;
                    queue.offer(new int[]{nextX, nextY});
                    visited[nextX][nextY] = true; 
                }
            }
        }

        return ans;
    }
}
