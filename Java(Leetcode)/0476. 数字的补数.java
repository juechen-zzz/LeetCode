/* 
给你一个 正 整数 num ，输出它的补数。补数是对该数的二进制表示取反。

 

示例 1：

输入：num = 5
输出：2
解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
示例 2：

输入：num = 1
输出：0
解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。

 */

class Solution {
    public int findComplement(int num) {
        int maxBitNum = 0;
        int tmp = num;
        while (tmp > 0) {
            maxBitNum++;
            tmp >>= 1;
        }
        return num ^ ((1 << maxBitNum) - 1);       // 异或
    }
}
