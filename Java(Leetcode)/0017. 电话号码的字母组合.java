/* 
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */

class Solution {
    public String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public StringBuilder sb = new StringBuilder();
    public List<String> ans = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {return ans;}
        backtrack(digits, 0);
        return ans;
    }

    public void backtrack(String digits, int index) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String val = map[digits.charAt(index) - '2'];

        for (char ch : val.toCharArray()) {
            sb.append(ch);
            backtrack(digits, index + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}