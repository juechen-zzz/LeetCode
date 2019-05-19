'''
Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:

Input: 3
Output:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
'''

class Solution(object):
    def generateMatrix(self, n):
        width = height = n
        matrix = []
        leg = 0  # moving right=0, moving down=1, moving left=2, moving up=3
        n = 1  # the first number we will write to array
        top_pad = 0
        right_pad = 0
        bottom_pad = 0
        left_pad = 0

        def add_to_matrix(row, column, value):
            if len(matrix) <= row:
                matrix.append([None]*width)  # Fill one row with empty Nulls
            matrix[row][column] = value

        while n <= width * height:
            if leg == 0:
                # Move horizontally right along the top
                for column in range(0 + left_pad, width - right_pad):
                    add_to_matrix(top_pad, column, n)
                    n += 1
                top_pad += 1
            elif leg == 1:
                # Move vertically down along the right edge
                for row in range(top_pad, height - bottom_pad):
                    add_to_matrix(row, width - 1 - right_pad, n)
                    n += 1
                right_pad += 1
            elif leg == 2:
                # Move horizontally left along the bottom
                for column in range(width - 1 - right_pad, -1 + left_pad, -1):
                    add_to_matrix(height - 1 - bottom_pad, column, n)
                    n += 1
                bottom_pad += 1
            elif leg == 3:
                # Move vertically up along the left edge
                for row in range(height - 1 - bottom_pad, -1 + top_pad, -1):
                    add_to_matrix(row, left_pad, n)
                    n += 1
                left_pad += 1
            if leg == 3:
                leg = 0
            else:
                leg += 1
        return matrix