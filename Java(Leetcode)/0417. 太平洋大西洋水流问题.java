/* 
给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。

规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。

请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。

提示：

输出坐标的顺序不重要
m 和 n 都小于150
 
示例：

给定下面的 5x5 矩阵:

  太平洋 ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * 大西洋

返回:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).

 */

class Solution {
    private int m, n;
    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private boolean inArea(int x, int y) {return 0 <= x && x < m && 0 <= y && y < n;}

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        if (heights.length == 0) {return ans;}

        m = heights.length;
        n = heights[0].length;
        int[][] po = new int[m][n], ao = new int[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, po);
            dfs(heights, i, n - 1, ao);
        }
        for (int i = 0; i < n; i++) {
            dfs(heights, 0, i, po);
            dfs(heights, m - 1, i, ao);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (po[i][j] == 1 && ao[i][j] == 1){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] matrix, int x, int y, int[][] tmp){
        tmp[x][y] = 1;
        for (int[] d : dir) {
            int newx = x + d[0];
            int newy = y + d[1];
            if (!inArea(newx, newy) || matrix[x][y] > matrix[newx][newy] || tmp[newx][newy] == 1){
                continue;
            }
            dfs(matrix, newx, newy, tmp);
        }
    }
}