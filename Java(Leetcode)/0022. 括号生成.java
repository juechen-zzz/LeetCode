/* 
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。



示例：

输入：n = 3
输出：[
       "((()))",
       "(()())",
       "(())()",
       "()(())",
       "()()()"
     ]

 */

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, StringBuilder sb, int start, int end, int n) {
        if (sb.length() == 2 * n) {
            ans.add(sb.toString());
            return;
        }

        if (start < n) {
            sb.append('(');
            backtrack(ans, sb, start + 1, end, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (end < start) {
            sb.append(')');
            backtrack(ans, sb, start, end + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
