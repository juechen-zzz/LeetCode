//
//  main.cpp
//  0044_Wildcard Matching
//
//  Created by 倪浩鹏 on 2020/4/13.
//  Copyright © 2020 nihaopeng. All rights reserved.
//

/*
 特殊字符串匹配，存在万能符
 
 Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*'.

 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).
 The matching should cover the entire input string (not partial).

 Note:

 s could be empty and contains only lowercase letters a-z.
 p could be empty and contains only lowercase letters a-z, and characters like ? or *.
 Example 1:

 Input:
 s = "aa"
 p = "a"
 Output: false
 Explanation: "a" does not match the entire string "aa".
 Example 2:

 Input:
 s = "aa"
 p = "*"
 Output: true
 Explanation: '*' matches any sequence.
 Example 3:

 Input:
 s = "cb"
 p = "?a"
 Output: false
 Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
 Example 4:

 Input:
 s = "adceb"
 p = "*a*b"
 Output: true
 Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
 Example 5:

 Input:
 s = "acdcb"
 p = "a*c?b"
 Output: false
 */

class Solution {
public:
    bool isMatch(string s, string p) {
        int n=s.size();
        int m=p.size();
        bool dp[n+1][m+1];
        for(int i=0;i<n+1;i++){
            for(int j=0;j<m+1;j++){
                dp[i][j]=false;
            }
        }
        dp[0][0]=true;
        for(int i=1;i<m+1;i++){
            if(p[i-1]=='*'){
                dp[0][i]=dp[0][i-1];
            }
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                if(s[i-1]==p[j-1] || p[j-1]=='?'){
                    dp[i][j]=dp[i-1][j-1];
                }else if(p[j-1]=='*'){
                    dp[i][j]=dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[n][m];
    }
};
