"""
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).


The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12
"""

class NumMatrix:

    def __init__(self, matrix: List[List[int]]):
        if not matrix or not matrix[0]: return
        rl, cl = len(matrix), len(matrix[0])
        self.m = [[0 for _ in range(cl+1)] for _ in range(rl+1)]
        for i in range(1, rl + 1):
            for j in range(1, cl + 1):
                self.m[i][j] = matrix[i-1][j-1] + self.m[i-1][j] + self.m[i][j-1] - self.m[i-1][j-1]

    def sumRegion(self, row1: int, col1: int, row2: int, col2: int) -> int:
        row1, col1, row2, col2 = row1+1, col1+1, row2+1, col2+1
        return self.m[row2][col2] - self.m[row2][col1-1] - self.m[row1 - 1][col2] + self.m[row1-1][col1-1]


# Your NumMatrix object will be instantiated and called as such:
# obj = NumMatrix(matrix)
# param_1 = obj.sumRegion(row1,col1,row2,col2)

