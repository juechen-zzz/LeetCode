/* 
给定一个正整数 n ，你可以做如下操作：

如果 n 是偶数，则用 n / 2替换 n 。
如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
n 变为 1 所需的最小替换次数是多少？

示例 1：

输入：n = 8
输出：3
解释：8 -> 4 -> 2 -> 1
示例 2：

输入：n = 7
输出：4
解释：7 -> 8 -> 4 -> 2 -> 1
或 7 -> 6 -> 3 -> 2 -> 1

 */

class Solution {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) {return 32;}
        if (n <= 3) {return n - 1;}
        if (n % 2 == 0) {
            return integerReplacement(n / 2) + 1;
        }
        else {
            return Math.min(integerReplacement(n - 1), integerReplacement(n + 1)) + 1;
        }
    }
}
