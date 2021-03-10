/* 
给出一个无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例 1：

输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]
示例 2：

输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。

 */

// 先复制一份，加入新的数组，再合并
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] intervalsAdd = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            intervalsAdd[i] = intervals[i];
        }
        intervalsAdd[intervals.length] = newInterval;
        return merge(intervalsAdd);
    }

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {return new int[0][2];}
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
            }
        });

        List<int[]> ans = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0], R = intervals[i][1];
            if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < L) {
                ans.add(new int[]{L, R});
            }
            else {
                ans.get(ans.size() - 1)[1] = Math.max(ans.get(ans.size() - 1)[1], R);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}

// 2 直接比较
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0], right = newInterval[1];
        boolean placed = false;
        List<int[]> ans = new ArrayList<>();
        for (int[] tmp : intervals) {
            if (tmp[0] > right) {
                if (!placed) {
                    ans.add(new int[]{left, right});
                    placed = true;
                }
                ans.add(tmp);
            }
            else if (tmp[1] < left) {
                ans.add(tmp);
            }
            else {
                left = Math.min(left, tmp[0]);
                right = Math.max(right, tmp[1]);
            }
        }

        if (!placed) {ans.add(new int[]{left, right});}
        return ans.toArray(new int[ans.size()][]);
    }
}
