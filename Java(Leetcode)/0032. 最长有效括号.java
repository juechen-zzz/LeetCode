/* 
给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。

 

示例 1：

输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"
示例 2：

输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"

 */

class Solution {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' && i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                dp[i] = dp[i - 1] + 2;
                if (i - dp[i - 1] - 2 >= 0) {
                    dp[i] += dp[i - dp[i - 1] - 2];
                }
            }
        }
        return getMax(dp);
    }

    public int getMax(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > ans) {
                ans = n;
            }
        }
        return ans;
    }
}