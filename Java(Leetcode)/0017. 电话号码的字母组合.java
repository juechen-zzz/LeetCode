/* 
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 */

class Solution {
    private static String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {return new ArrayList<>();}
        
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        myMethod(digits, ans, sb, 0);
        return ans;
    }

    private static void myMethod(String digits, List<String> ans, StringBuilder sb,  int idx) {
        if (sb.length() == digits.length()) {
            ans.add(sb.toString());
            return;
        }

        String val = map[digits.charAt(idx) - '2'];

        for (char c : val.toCharArray()) {
            sb.append(c);
            myMethod(digits, ans, sb, idx + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}