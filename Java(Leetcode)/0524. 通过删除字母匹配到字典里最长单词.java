/* 
给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。

示例 1:

输入:
s = "abpcplea", d = ["ale","apple","monkey","plea"]

输出: 
"apple"
示例 2:

输入:
s = "abpcplea", d = ["a","b","c"]

输出: 
"a"

 */

class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String cur : dictionary) {
            if (isSubsequence(cur, s)) {
                if (cur.length() > ans.length() || (cur.length() == ans.length() && cur.compareTo(ans) < 0)) {
                    ans = cur;
                }
            }
        }
        return ans;
    }

    private static boolean isSubsequence(String x, String y) {
        int idx = 0;
        for (int i = 0; i < y.length() && idx < x.length(); i++) {
            if (x.charAt(idx) == y.charAt(i)) {
                idx++;
            }
        }
        return idx == x.length();
    }
}