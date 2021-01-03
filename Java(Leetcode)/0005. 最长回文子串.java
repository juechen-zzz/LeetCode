/* 
给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

示例 1：

输入: "babad"
输出: "bab"
注意: "aba" 也是一个有效答案。
示例 2：

输入: "cbbd"
输出: "bb"

 */

// DP
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int i = n - 1; i >= 0; i--){
            for (int j = i; j < n; j++){
                if (i == j) {dp[i][j] = true;}
                else if (j - i == 1) {dp[i][j] = (s.charAt(i) == s.charAt(j));}
                else {
                    dp[i][j] = ((s.charAt(i) == s.charAt(j)) && dp[i + 1][j - 1]);
                }

                if (dp[i][j] && (j - i + 1 >= ans.length())){
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;
    }
}

// 中心扩散
class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int idx = 0;
        while (idx < s.length()) {
            int left = idx, right = idx;
            while (left - 1 >= 0 && s.charAt(left) == s.charAt(left - 1)){left--;}
            while (right + 1 < s.length() && s.charAt(right) == s.charAt(right + 1)) {right++;}
            
            idx = right + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }

            if (right - left - 1 > ans.length()) {
                ans = s.substring(left + 1, right);
            }
        }
        return ans;
    }
}
