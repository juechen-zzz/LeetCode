//
//  main.cpp
//  0120_Triangle
//
//  Created by 倪浩鹏 on 2020/6/11.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
    三角形数组的最短路径和
 */

class Solution {
public:
    int minimumTotal(vector<vector<int>>& triangle) {
        int n=triangle.size();
        for(int i=1;i<n;i++)
        {
            int t=triangle[i].size();
            for(int j=0;j<t;j++)
            {
                // 上一行必须要考虑头尾情况，头为0，尾为t-2
                triangle[i][j] += min(triangle[i-1][max(0,j-1)], triangle[i-1][min(t-2,j)]);
            }
        }
        
        int ans=INT_MAX;
        for(int i=0;i<triangle[n-1].size();i++)
        {
            ans=min(ans, triangle[n-1][i]);
        }
        return ans;
    }
};
