//
//  main.cpp
//  0064_Minimum Path Sum
//
//  Created by 倪浩鹏 on 2020/5/9.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 最小路径和 https://blog.csdn.net/zxzxzx0119/article/details/81227300
 
 递归

 加入我们就在最右下角的格子(也可以想象成网格只有一个格子)，那么最短路径和就是格子中的值；
 然后假如我们在最后一行的格子中，假如是grid[grid.length][j]，那么从这个点出发到最右下角的最小路径和就是本身加上它左边的格子到最右下角的最小路径和。
 
 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.

 Example:

 Input:
 [
   [1,3,1],
   [1,5,1],
   [4,2,1]
 ]
 Output: 7
 Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */



// solution 1 递归 递归是从上往下求解，每个大的问题都要先去求解子问题
class Solution {
public:
    int m, n;
    
    int rec(vector<vector<int>>& grid, int i, int j){
        if (i == m-1 && j == n-1) return grid[i][j];
        if (i == m - 1) return grid[i][j] + rec(grid, i, j + 1);
        if (j == n - 1) return grid[i][j] + rec(grid, i + 1, j);
        return grid[i][j] + min(rec(grid, i + 1, j), rec(grid, i, j + 1));
    }
    
    int minPathSum(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size();
        return rec(grid, 0, 0);
    }
};

// solution 2 DP 动态规划是先求解小的子问题，依次往上，所以大问题需要的子问题已经提前求好了
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        if (grid.size() == 0 || grid[0].size() == 0)
            return 0;
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        dp[m-1][n-1] = grid[m-1][n-1];
        for (int i = m-2; i >= 0; i--) dp[i][n-1] = dp[i+1][n-1] + grid[i][n-1];
        for (int j = n-2; j >= 0; j--) dp[m-1][j] = dp[m-1][j+1] + grid[m-1][j];
        for (int i = m-2; i >= 0; i--) {
            for (int j = n-2; j >= 0; j--) {
                dp[i][j] = min(dp[i + 1][j], dp[i][j + 1]) + grid[i][j];
            }
        }
        return dp[0][0];
    }
};

// solution 3 DP 优化空间，空间复杂度控制在O(min{N,M})内,只创建一个一维数组
class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        if (grid.size() == 0 || grid[0].size() == 0)
            return 0;
        int m = grid.size();
        int n = grid[0].size();
        bool rowMore = (m >= n);
        
        int big = max(m-1, n-1);
        int small = min(m-1, n-1);
        vector<int> dp(small+1, 0);
        dp[small] = grid[m-1][n-1];
        
        for (int i = small-1; i >= 0; i--){
            dp[i] = dp[i+1] + (rowMore?grid[big][i]:grid[i][big]);
        }
        
        for (int i = big-1; i >= 0; i--){
            dp[small] = dp[small] + (rowMore?grid[i][small]:grid[small][i]);
            for (int j = small-1; j >= 0; j--){
                dp[j] = min(dp[j], dp[j+1]) + (rowMore?grid[i][j]:grid[j][i]);
            }
        }
        return dp[0];
    }
};


