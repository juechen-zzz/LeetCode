"""
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

从最左上角开始遍历这个网格图，当遍历到该点值为1的时候，将其更新为0，并以该点进行扩展，扩展方式为上下左右四个方向，
扩展到的陆地（即值为1）将其值更新为0，直到不能扩展。陆地数+1，再继续遍历下一个值为1点的，更新为0后进行扩展。
"""

class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        num = 0
        self.grid = grid
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if self.grid[i][j] == '1':
                    self.dfs(i, j)
                    num += 1
        return num
    
    def dfs(self, row, col):
        if row < 0 or row > len(self.grid) - 1 or col < 0 or col > len(self.grid[0]) - 1: return
        
        if self.grid[row][col] == '1':
            self.grid[row][col] = '0'
            self.dfs(row - 1, col)
            self.dfs(row + 1, col)
            self.dfs(row, col - 1)
            self.dfs(row, col + 1)
        
        return 