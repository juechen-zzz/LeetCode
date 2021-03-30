/* 
给你一个仅由大写英文字母组成的字符串，你可以将任意位置上的字符替换成另外的字符，总共可最多替换 k 次。在执行上述操作后，找到包含重复字母的最长子串的长度。

注意：字符串长度 和 k 不会超过 104。

 

示例 1：

输入：s = "ABAB", k = 2
输出：4
解释：用两个'A'替换为两个'B',反之亦然。
示例 2：

输入：s = "AABABBA", k = 1
输出：4
解释：
将中间的一个'A'替换为'B',字符串变为 "AABBBBA"。
子串 "BBBB" 有最长重复字母, 答案为 4。

 */

class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        if (n < 2) {return n;}

        char[] charArray = s.toCharArray();
        int left = 0, right = 0;
        int ans = 0, maxCount = 0;
        int[] count = new int[26];

        while (right < n) {
            count[charArray[right] - 'A']++;
            maxCount = Math.max(maxCount, count[charArray[right] - 'A']);
            right++;

            if (right - left > maxCount + k) {
                count[charArray[left] - 'A']--;
                left++;
            }
            
            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}