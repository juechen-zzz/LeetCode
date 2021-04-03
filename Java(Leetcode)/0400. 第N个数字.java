/* 
在无限的整数序列 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...中找到第 n 个数字。

注意:
n 是正数且在32位整数范围内 ( n < 231)。

示例 1:
输入:
3
输出:
3

示例 2:
输入:
11
输出:
0

 */

class Solution {
    public int findNthDigit(int n) {
        long num = n, size = 1, max = 9;

        while (n > 0){
            if (num - size * max > 0){
                num -= size * max;
                size++;
                max = max * 10;
            }
            else {
                long count = num / size;
                long left = num % size;
                if (left == 0){
                    return (int)((Math.pow(10, size - 1) + count - 1) % 10);
                }
                else {
                    return (int)(((Math.pow(10, size - 1) + count) / Math.pow(10, size - left)) % 10);
                }
            } 
        }
        return 0;
    }
}