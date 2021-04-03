/* 
给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。

示例 1：

输入：s = "aaabb", k = 3
输出：3
解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
示例 2：

输入：s = "ababbc", k = 2
输出：5
解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。

 */

class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        int n = s.length();

        // 枚举最长子串中的字符种类
        // total:窗口内的字符种类数目
        // less:窗口中还有几种字符未达到k次
        for (int i = 1; i <= 26; i++) {
            int left = 0, right = 0;
            int[] count = new int[26];
            int total = 0, less = 0;

            while (right < n) {
                count[s.charAt(right) - 'a']++;
                if (count[s.charAt(right) - 'a'] == 1) {
                    total++;
                    less++;
                }
                if (count[s.charAt(right) - 'a'] == k) {
                    less--;
                }

                while (total > i) {
                    count[s.charAt(left) - 'a']--;
                    if (count[s.charAt(left) - 'a'] == k - 1) {
                        less++;
                    }
                    if (count[s.charAt(left) - 'a'] == 0) {
                        total--;
                        less--;
                    }
                    left++;
                }
                if (less == 0) {ans = Math.max(ans, right - left + 1);}
                right++;
            }
        }
        return ans;
    }
}