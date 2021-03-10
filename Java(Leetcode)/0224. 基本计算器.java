/* 
实现一个基本的计算器来计算一个简单的字符串表达式 s 的值。

 

示例 1：

输入：s = "1 + 1"
输出：2
示例 2：

输入：s = " 2-1 + 2 "
输出：3
示例 3：

输入：s = "(1+(4+5+2)-3)+(6+8)"
输出：23

 */

class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int sign = 1;

        int ans = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c == ' ') {i++;}
            else if (c == '+') {
                sign = stack.peek();
                i++;
            }
            else if (c == '-') {
                sign = -stack.peek();
                i++;
            }
            else if (c == '(') {
                stack.push(sign);
                i++;
            }
            else if (c == ')') {
                stack.pop();
                i++;
            }
            else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                ans += sign * num;
            }
        }

        return ans;
    }
}
