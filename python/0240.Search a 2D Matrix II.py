"""
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.

"""

class Solution:
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if not matrix: return False
        raws = len(matrix)
        cols = len(matrix[0])

        i = 0
        j = cols - 1 

        while 0 <= i < raws and 0 <= j < cols:
            if matrix[i][j] < target:
                i += 1
            elif  matrix[i][j] > target:
                j -= 1
            else:
                return True
        return False
