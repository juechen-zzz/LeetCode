/* 
给定一个字符串 s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。

重复出现的子串要计算它们出现的次数。

 

示例 1 :

输入: "00110011"
输出: 6
解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。

请注意，一些重复出现的子串要计算它们出现的次数。

另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
示例 2 :

输入: "10101"
输出: 4
解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。

 */

class Solution {
    public int countBinarySubstrings(String s) {
        List<Integer> count = new ArrayList<>();
        int idx = 0, n = s.length();
        
        while (idx < n) {
            char c = s.charAt(idx);
            int cur = 0;
            while (idx < n && s.charAt(idx) == c) {
                idx++;
                cur++;
            }
            count.add(cur);
        }

        int ans = 0;
        for (int i = 1; i < count.size(); i++) {
            ans += Math.min(count.get(i), count.get(i - 1));
        }

        return ans;
    }
}