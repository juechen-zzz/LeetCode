//
//  main.cpp
//  0063_Unique Paths II
//
//  Created by 倪浩鹏 on 2020/5/9.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 跳跃路径数2（有障碍）
 
 An obstacle and empty space is marked as 1 and 0 respectively in the grid.

 Note: m and n will be at most 100.

 Example 1:

 Input:
 [
   [0,0,0],
   [0,1,0],
   [0,0,0]
 ]
 Output: 2
 Explanation:
 There is one obstacle in the middle of the 3x3 grid above.
 There are two ways to reach the bottom-right corner:
 1. Right -> Right -> Down -> Down
 2. Down -> Down -> Right -> Right
 */

// runtime error
class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& o) {
        int m=o.size();
        int n=o[0].size();
        if(n==0 && m==0) {return 0;}
        if(o[0][0]==1 || o[n-1][m-1]==1) {return 0;}
        
        vector<vector<int>> dp(n,vector<int>(m,0));
        dp[0][0]=1;
        
        for(int i=1;i<n;i++){
            if(o[0][i]!=1)
                dp[0][i]=dp[0][i-1];
        }
        for(int i=1;i<m;i++){
            if(o[i][0]!=1)
                dp[i][0]=dp[i-1][0];
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(o[i][j]!=1){
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
};

//solution 2
class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        // dp
        //. convert obstcles to -1
        if(obstacleGrid.empty()) return 0;
        if(obstacleGrid[0][0]==1) return 0;
        
        int h= obstacleGrid.size();
        int w = obstacleGrid[0].size();
        vector<vector<long>> dp (h,vector<long>(w));
            
        for(int i=0;i<h;i++)
        {
            for(int j=0;j<w;j++)
                if(obstacleGrid[i][j]==1)
                    dp[i][j]=-1;
        }
         
        for(int i=0;i<w;i++)
        {
            if(dp[0][i]==-1) break;
            
                dp[0][i]=1;
        }
        
        for(int i=0;i<h;i++)
        {
            if(dp[i][0]==-1) break;
            
                dp[i][0]=1;
        }
        
        for(int i=1;i<h;i++)
        {
            for(int j=1;j<w;j++){
                if(dp[i-1][j]==-1 && dp[i][j-1]==-1) continue;
                if(dp[i][j]==-1) continue;
                
                if(dp[i-1][j]==-1)
                    dp[i][j] = dp[i][j-1];
                else if(dp[i][j-1]==-1)
                    dp[i][j]= dp[i-1][j];
                else{
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
                
        }
        
        return dp[h-1][w-1]<0 ? 0 : dp[h-1][w-1];
    }
};
