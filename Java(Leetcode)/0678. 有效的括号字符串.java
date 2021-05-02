/* 
给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：

任何左括号 ( 必须有相应的右括号 )。
任何右括号 ) 必须有相应的左括号 ( 。
左括号 ( 必须在对应的右括号之前 )。
* 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
一个空字符串也被视为有效字符串。
示例 1:

输入: "()"
输出: True
示例 2:

输入: "(*)"
输出: True
示例 3:

输入: "(*))"
输出: True

 */

// solution 1
class Solution {
    public boolean checkValidString(String s) {
        int left = 0, right = 0, n = s.length();
        for (int i = 0; i < n; i++) {
            left += (s.charAt(i) == ')') ? -1 : 1;
            right += (s.charAt(n - i - 1) == '(') ? -1 : 1;
            if (left < 0 || right < 0) {
                return false;
            }
        }
        return true;
    }
}

// solution 2 stack
class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Stack<Integer> left = new Stack<>();
        Stack<Integer> star = new Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {left.push(i);}
            else if (c == '*') {star.push(i);}
            else {
                if (!left.isEmpty()) {left.pop();}
                else if (!star.isEmpty()) {star.pop();}
                else {return false;}
            }
        }

        if (left.size() > star.size()) {return false;}
        else {
            while (!left.isEmpty() && !star.isEmpty()) {
                if (left.peek() > star.peek()) {return false;}
                star.pop();
                left.pop();
            }
            return true;
        }
    }
}