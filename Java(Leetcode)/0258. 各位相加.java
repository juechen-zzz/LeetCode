/* 
给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。

示例:

输入: 38
输出: 2 
解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。

 */

class Solution {
    public int addDigits(int num) {
        if (num < 10) {return num;}
        while (num >= 10) {
            num = getNextNum(num);
        }
        return num;
    }

    public int getNextNum(int num) {
        int ans = 0;
        while (num > 0) {
            ans += (num % 10);
            num /= 10;
        }
        return ans;
    }
}