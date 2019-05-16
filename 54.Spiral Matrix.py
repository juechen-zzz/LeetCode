'''
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
'''

class Solution:
    def spiralOrder(self, matrix):

        if matrix == []: return []

        top = 0  # 上边
        bottom = len(matrix) - 1  # 下边
        left = 0  # 左边
        right = len(matrix[0]) - 1  # 右边

        res = []

        while top < bottom and left < right:

            res += matrix[top][left:right + 1]  # 输出最上面一行数据

            for x in range(top + 1, bottom):  # 输出最右边一列数据
                res.append(matrix[x][right])

            res += matrix[bottom][left:right + 1][::-1]  # 输出最下面一行数据

            for x in range(bottom - 1, top, -1):  # 输出最左边一列数据
                res.append(matrix[x][left])

            top, bottom, left, right = top + 1, bottom - 1, left + 1, right - 1  # 四个边界，分别向内部移动一个位置

        if top == bottom:  # 如果最后剩下一行数据
            res += matrix[top][left:right + 1]
        elif left == right:  # 如果最后剩下一列数据
            for x in range(top, bottom + 1):
                res.append(matrix[x][right])

        return res
