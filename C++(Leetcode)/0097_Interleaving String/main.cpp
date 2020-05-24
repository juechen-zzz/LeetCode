//
//  main.cpp
//  0097_Interleaving String
//
//  Created by 倪浩鹏 on 2020/5/24.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

 Example 1:

 Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 Output: true
 Example 2:

 Input: s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 Output: false
 */

class Solution {
public:
    bool isInterleave( string s1, string s2, string s3 ) {
        int m = s1.size(), n = s2.size();
        if( s3.size() != m + n )  return false;

        vector<vector<bool>> dp( m+1, vector<bool>( n+1, false ));

        // init, base case
        dp[0][0] = true;
        for( int i = 1; i <= m; i++ ) // go down
            dp[i][0] = dp[i-1][0] && ( s1[i - 1] == s3[i - 1] );

        for( int i = 1; i <= n; i++ ) // go right
            dp[0][i] = dp[0][i - 1] && ( s2[i - 1] == s3[i - 1] );

        for( int i = 1; i <= m; i++ )
            for( int j = 1; j <= n; j++ ) {
                if( s1[i - 1] == s3[i + j - 1] && dp[i - 1][j] )
                    dp[i][j] = true;
                else if( s2[j - 1] == s3[i + j - 1] && dp[i][j - 1])
                    dp[i][j] = true;
            }
        return dp[m][n];
    }
};
