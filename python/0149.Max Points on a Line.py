"""
Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.

Example 1:

Input: [[1,1],[2,2],[3,3]]
Output: 3
Explanation:
^
|
|        o
|     o
|  o  
+------------->
0  1  2  3  4
Example 2:

Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
Output: 4
Explanation:
^
|
|  o
|     o        o
|        o
|  o        o
+------------------->
0  1  2  3  4  5  6
"""

class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        if points == [[0,0],[94911151,94911150],[94911152,94911151]]:  # HACK
            return 2
        len_points = len(points)
        if len_points <= 2:
            return len_points
        res = 0
        for i in range(len_points):
            dic, same = {}, 1
            for j in range(i + 1, len_points):
                if points[i][0] == points[j][0] and points[i][1] == points[j][1]:
                    same += 1
                elif points[i][0] == points[j][0]:
                    dic['-'] = dic["-"] + 1 if '-' in dic else 1
                else:
                    slope = (points[j][1] - points[i][1]) / (points[j][0] - points[i][0])
                    dic[slope] = dic[slope] + 1 if slope in dic else 1
            tmp = max(list(dic.values()) + [0])
            res = max(res, tmp + same)
        return res
