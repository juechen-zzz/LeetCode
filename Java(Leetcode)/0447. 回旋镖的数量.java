/* 
给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组 ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。

返回平面上所有回旋镖的数量。


示例 1：

输入：points = [[0,0],[1,0],[2,0]]
输出：2
解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
示例 2：

输入：points = [[1,1],[2,2],[3,3]]
输出：2
示例 3：

输入：points = [[1,1]]
输出：0

 */

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;

        int n = points.length;
        for (int i = 0; i < n; i++) {
            Map<Integer, Integer> record = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    int curDistance = distance(points[i], points[j]);
                    record.put(curDistance, record.getOrDefault(curDistance, 0) + 1);
                }
            }

            for (int k : record.values()) {
                ans += k * (k - 1);
            }
        }

        return ans;
    }

    private int distance(int[] A, int[] B) {
        return (A[0] - B[0]) * (A[0] - B[0]) + (A[1] - B[1]) * (A[1] - B[1]);
    }
}