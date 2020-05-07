//
//  main.cpp
//  0062_Unique Paths
//
//  Created by 倪浩鹏 on 2020/5/7.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 跳跃路径数
 
 Example 1:

 Input: m = 3, n = 2
 Output: 3
 Explanation:
 From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 1. Right -> Right -> Down
 2. Right -> Down -> Right
 3. Down -> Right -> Right
 Example 2:

 Input: m = 7, n = 3
 Output: 28
 */

class Solution {
public:
    int uniquePaths(int m, int n){

        if(m==1 || n==1)
            return 1;

        int arr[m][n];
        arr[0][0]=1;

        for(int i=1;i<m;i++){
            arr[i][0]=1;
        }
        for(int j=1;j<n;j++)
            arr[0][j]=1;

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }
};
