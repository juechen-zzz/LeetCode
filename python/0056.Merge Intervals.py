'''
Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
'''

class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        if len(intervals) == 0: return []
        # 以第一个元素为key进行子数组排序
        intervals.sort(key = lambda x: x[0])

        ret = [intervals[0]]
        for x in intervals[1:]:
            if x[0] <= ret[-1][1]:
                ret[-1][1] = max(ret[-1][1], x[1])
            else:
                ret.append(x)
        return ret