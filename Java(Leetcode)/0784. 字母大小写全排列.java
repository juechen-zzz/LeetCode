/* 
给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。

 

示例：
输入：S = "a1b2"
输出：["a1b2", "a1B2", "A1b2", "A1B2"]

输入：S = "3z4"
输出：["3z4", "3Z4"]

输入：S = "12345"
输出：["12345"]

 */

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<StringBuilder> cur = new ArrayList<>();
        cur.add(new StringBuilder());

        for (char c : s.toCharArray()) {
            int n = cur.size();
            if (Character.isLetter(c)) {
                for (int i = 0; i < n; i++) {
                    cur.add(new StringBuilder(cur.get(i)));
                    cur.get(i).append(Character.toLowerCase(c));
                    cur.get(n + i).append(Character.toUpperCase(c));
                }
            }
            else {
                for (int i = 0; i < n; i++) {
                    cur.get(i).append(c);
                }
            }
        }

        List<String> ans = new ArrayList<>();
        for (StringBuilder sb : cur) {ans.add(sb.toString());}
        return ans;
    }
}