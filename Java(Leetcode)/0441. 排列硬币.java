/* 
你总共有 n 枚硬币，你需要将它们摆成一个阶梯形状，第 k 行就必须正好有 k 枚硬币。

给定一个数字 n，找出可形成完整阶梯行的总行数。

n 是一个非负整数，并且在32位有符号整型的范围内。

示例 1:

n = 5

硬币可排列成以下几行:
¤
¤ ¤
¤ ¤

因为第三行不完整，所以返回2.

 */

class Solution {
    public int arrangeCoins(int n) {
        int low = 1, high = n;
        long mid, sum;
        while(low <= high) {
            mid = low + (high - low ) / 2;
            sum = mid * (mid + 1) / 2;
            if(sum == n){
                return (int)mid;
            }
            else if (n > sum){
                low = (int)mid + 1;
            }
            else{
                high = (int)mid - 1;
            }
        }
        return high;
    }
}