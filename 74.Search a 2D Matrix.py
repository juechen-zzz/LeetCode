'''
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
Example 1:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 3
Output: true
Example 2:

Input:
matrix = [
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
target = 13
Output: false
'''

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        a = []
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                a.append(matrix[i][j])
        if target in a:
            return True
        else:
            return False

class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return False
        
        m = len(matrix) - 1
        n = len(matrix[0]) - 1
        
        current_index = 0
        low = 0
        while current_index <= m:
            mid = int((current_index + m) / 2)
            if target < matrix[mid][0]:
                m = mid - 1
            elif target > matrix[mid][0]:
                current_index = mid + 1
            else:
                return True
        
        while low <= n:
            mid = int((low + n) / 2)
            if target < matrix[m][mid]:
                n = mid - 1
            elif target > matrix[m][mid]:
                low = mid + 1
            else:
                return True
        return False