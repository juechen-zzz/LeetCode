/* 
给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。

区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。

返回一个由每个区间 i 的 右侧区间 的最小起始位置组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。

 
示例 1：

输入：intervals = [[1,2]]
输出：[-1]
解释：集合中只有一个区间，所以输出-1。
示例 2：

输入：intervals = [[3,4],[2,3],[1,2]]
输出：[-1, 0, 1]
解释：对于 [3,4] ，没有满足条件的“右侧”区间。
对于 [2,3] ，区间[3,4]具有最小的“右”起点;
对于 [1,2] ，区间[2,3]具有最小的“右”起点。
示例 3：

输入：intervals = [[1,4],[2,3],[3,4]]
输出：[-1, 2, -1]
解释：对于区间 [1,4] 和 [3,4] ，没有满足条件的“右侧”区间。
对于 [2,3] ，区间 [3,4] 有最小的“右”起点。

 */

class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {map.put(intervals[i][0], i);}

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int left = i, right = n - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (intervals[mid][0] >= intervals[i][1]) {
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }

            if (intervals[i][1] > intervals[right][0] || i == n - 1) {
                ans[map.get(intervals[i][0])] = -1;
            }
            else {
                ans[map.get(intervals[i][0])] = map.get(intervals[right][0]);
            }
        }

        return ans;
    }
}
