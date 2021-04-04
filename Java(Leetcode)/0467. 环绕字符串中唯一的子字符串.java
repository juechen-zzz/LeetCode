/* 
把字符串 s 看作是“abcdefghijklmnopqrstuvwxyz”的无限环绕字符串，所以 s 看起来是这样的："...zabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcd....". 

现在我们有了另一个字符串 p 。你需要的是找出 s 中有多少个唯一的 p 的非空子串，尤其是当你的输入是字符串 p ，你需要输出字符串 s 中 p 的不同的非空子串的数目。 

注意: p 仅由小写的英文字母组成，p 的大小可能超过 10000。

 

示例 1:

输入: "a"
输出: 1
解释: 字符串 S 中只有一个"a"子字符。
 

示例 2:

输入: "cac"
输出: 2
解释: 字符串 S 中的字符串“cac”只有两个子串“a”、“c”。.
 

示例 3:

输入: "zab"
输出: 6
解释: 在字符串 S 中有六个子串“z”、“a”、“b”、“za”、“ab”、“zab”。.

 */

class Solution {
    public int findSubstringInWraproundString(String p) {
        // 连续子串c 中以字符c 结尾的连续子串有c，
        // 连续子串bc 中以字符c 结尾的连续子串有c、bc；
        // 连续子串abc 中以字符c 结尾的连续子串有c、bc、abc。
        
        // 以该字符结尾的连续子串的长度，就等于以该字符结尾的相等子串的个数。
        // 统计所有以每个字符结尾的最长连续子串的长度，就是唯一相等子串的个数
        int[] dp = new int[26];
        char[] array = p.toCharArray();

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (i > 0 && (array[i] - array[i - 1] - 1) % 26 == 0) {count++;}
            else {count = 1;}

            dp[array[i] - 'a'] = Math.max(dp[array[i] - 'a'], count);
        }

        int ans = 0;
        for (int n : dp) {ans += n;}
        return ans;
    }
}