/* 
在一个 XY 坐标系中有一些点，我们用数组 coordinates 来分别记录它们的坐标，其中 coordinates[i] = [x, y] 表示横坐标为 x、纵坐标为 y 的点。

请你来判断，这些点是否在该坐标系中属于同一条直线上，是则返回 true，否则请返回 false。

示例 1：
输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
输出：true

 */

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if (n < 3) {return true;}
        int x0 = coordinates[0][0], y0 = coordinates[0][1];
        int x = coordinates[1][0] - x0;
        int y = coordinates[1][1] - y0;
        for (int i = 2; i < n; i++) {
            int xi = coordinates[i][0] - x0;
            int yi = coordinates[i][1] - y0;
            if (x * yi - y * xi != 0) { 
                return false;
            }
        }
        return true;
    }
}