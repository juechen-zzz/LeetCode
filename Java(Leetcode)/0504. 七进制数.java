/* 
给定一个整数，将其转化为7进制，并以字符串形式输出。

示例 1:

输入: 100
输出: "202"
示例 2:

输入: -7
输出: "-10"
 */

class Solution {
    public String convertToBase7(int num) {
        StringBuilder ans = new StringBuilder();
        if (num == 0) {
            ans.append("0");
            return ans.toString();
        }

        boolean flag = false;
        if (num < 0) {
            num = -num;
            flag = true;
        }

        while (num != 0) {
            ans.append(num % 7);
            num /= 7;
        }

        ans.reverse();
        if (flag) {ans.insert(0, "-");}

        return ans.toString();
    }
}