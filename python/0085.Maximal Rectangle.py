'''
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

Example:

Input:
[
  ["1","0","1","0","0"],
  ["1","0","1","1","1"],
  ["1","1","1","1","1"],
  ["1","0","0","1","0"]
]
Output: 6
'''

class Solution(object):
    def maximalRectangle(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if not matrix or len(matrix) == 0:
            return 0
        m, n = len(matrix), len(matrix[0])
        ans = 0
        
        left, right, height = [0] * n, [n] * n, [0] * n
        for i in range(m):
            curl = 0
            for j in range(n):
                if matrix[i][j] == '1':
                    left[j] = max(curl, left[j])
                else:
                    left[j] = 0
                    curl = j + 1
            curr = n
            for j in range(n-1, -1, -1):
                if matrix[i][j] == '1':
                    right[j] = min(curr, right[j])
                else:
                    right[j] = n
                    curr = j
            for j in range(n):
                if matrix[i][j] == '1':
                    height[j] += 1
                else:
                    height[j] = 0
                ans = max(height[j] * (right[j] - left[j]), ans)
        return ans