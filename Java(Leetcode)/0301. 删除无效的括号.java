/* 
删除最小数量的无效括号，使得输入的字符串有效，返回所有可能的结果。

说明: 输入可能包含了除 ( 和 ) 以外的字符。

示例 1:

输入: "()())()"
输出: ["()()()", "(())()"]
示例 2:

输入: "(a)())()"
输出: ["(a)()()", "(a())()"]
示例 3:

输入: ")("
输出: [""]

 */

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        set.add(s);
        while (true) {
            for (String str : set) {
                if (isRegular(str))
                    ans.add(str);
            }
            if (ans.size() > 0) return ans;
            Set<String> nextSet = new HashSet<>();
            for (String str : set) {
                for (int i = 0; i < str.length(); i ++) {
                    if (str.charAt(i) == '(' || str.charAt(i) == ')')
                        nextSet.add(str.substring(0, i) + str.substring(i + 1, str.length()));
                }
            }
            set = nextSet;
        }
    }
    
    public boolean isRegular(String s) {
        char[] ss = s.toCharArray();
        int count = 0;
        for (char c : ss) {
            if (c == '(') count ++;
            else if (c == ')') count --;
            if (count < 0) return false;
        }
        return count == 0;
    }
}
