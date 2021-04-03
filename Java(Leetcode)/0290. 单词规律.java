/* 
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。

示例1:

输入: pattern = "abba", str = "dog cat cat dog"
输出: true
示例 2:

输入:pattern = "abba", str = "dog cat cat fish"
输出: false
示例 3:

输入: pattern = "aaaa", str = "dog cat cat dog"
输出: false
示例 4:

输入: pattern = "abba", str = "dog dog dog dog"
输出: false

 */

class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        String[] strs = s.split(" ");
        int n = strs.length;
        if (n != pattern.length()) {return false;}

        for (int i = 0; i < n; i++) {
            char c = pattern.charAt(i);
            if (!map.containsKey(c)) {
                if (!map.containsValue(strs[i])) {
                    map.put(c, strs[i]);
                }
                else {
                    return false;
                }
            }
            else if (!map.get(c).equals(strs[i])) {
                return false;
            }
        }

        return true;
    }
}