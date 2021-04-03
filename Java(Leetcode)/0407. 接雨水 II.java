/* 
给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。

示例：

给出如下 3x6 的高度图:
[
  [1,4,3,1,3,2],
  [3,2,1,3,2,4],
  [2,3,3,2,3,1]
]

返回 4 。
如上图所示，这是下雨前的高度图[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]] 的状态。

 */

class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap.length == 0) {return 0;}
        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    pq.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;
        int[] dirs = {-1, 0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] curPoint = pq.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = curPoint[0] + dirs[i];
                int nextY = curPoint[1] + dirs[i + 1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextX][nextY]) {
                    if (curPoint[2] > heightMap[nextX][nextY]) {
                        ans += curPoint[2] - heightMap[nextX][nextY];
                    }
                    pq.offer(new int[]{nextX, nextY, Math.max(heightMap[nextX][nextY], curPoint[2])});
                    visited[nextX][nextY] = true;
                }
            }
        }

        return ans;
    }
}