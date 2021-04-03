/* 
给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。

在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。

注意:
假设字符串的长度不会超过 1010。

示例 1:

输入:
"abccccdd"

输出:
7

解释:
我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。

 */

class Solution {
    public int longestPalindrome(String s) {
        if (s.length() == 0) {return 0;}
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
        }

        int ans = 0;
        boolean single = true;
        for (char c : count.keySet()) {
            if (single && ((count.get(c) & 1) == 1)) {
                ans += count.get(c);
                single = false;
            }
            else {
                ans += (((count.get(c) & 1) == 0) ? count.get(c) : count.get(c) - 1);
            }
        }
        return ans;
    }
}