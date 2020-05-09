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


// solution 2
int uniquePaths(int m, int n)
{
    int prev = 0,active = 1,columnCount = min(m,n),elementCount=0;
    vector<vector<int>> temp(2,vector<int>(columnCount,1));
    while(elementCount<((m-1)*(n-1)))
    {
        for(int i=1;i<columnCount;i++)
        {
            temp[active][i] = temp[prev][i]+temp[active][(i-1)];
            elementCount++;
        }
        swap(prev,active);
    }

    return temp[prev][columnCount-1];
}

