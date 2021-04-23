/* 
给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。

具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

 

示例 1：

输入："abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：

输入："aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

 */

class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                //如果i和j指向的字符不一样，那么dp[i][j]就不能构成回文字符串
                if (s.charAt(i) != s.charAt(j)) {continue;}
                dp[i][j] = (j - i <= 2 || dp[i + 1][j - 1]);
                //如果从i到j能构成回文串，count就加1
                if (dp[i][j]) {ans++;}
            }
        }

        return ans;
    }
}