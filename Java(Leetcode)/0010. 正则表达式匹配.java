/* 
给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。

'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。

 
示例 1：

输入：s = "aa" p = "a"
输出：false
解释："a" 无法匹配 "aa" 整个字符串。
示例 2:

输入：s = "aa" p = "a*"
输出：true
解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
示例 3：

输入：s = "ab" p = ".*"
输出：true
解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。

 */

class Solution {
    public boolean isMatch(String s, String p) {
        //初始化dp[0][0]=true,dp[0][1]和dp[1][0]~dp[s.length][0]默认值为false所以不需要显式初始化
        //填写第一行dp[0][2]~dp[0][p.length]
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int k = 2; k <= p.length(); k++){
            dp[0][k] = p.charAt(k - 1) == '*' && dp[0][k-2];
        }

        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                if (p.charAt(j) == '*'){
                    // 1.只匹配0次，s不变[i+1], p移除两个元素[j+1-2]。
                    // 2.比较s的i元素和p的j-1(因为此时j元素为*)元素,相等则移除首元素[i+1-1],p不变。
                    dp[i+1][j+1] = dp[i+1][j-1] || (dp[i][j+1] && headMatched(s, p, i, j-1));
                }else {
                    dp[i+1][j+1] =  dp[i][j] && headMatched(s, p, i, j);
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    //判断s第i个字符和p第j个字符是否匹配
    public boolean headMatched(String s,String p,int i,int j){
        return (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
    }
}
