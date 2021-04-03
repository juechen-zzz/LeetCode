/* 
给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:

输入: 2
输出: [0,1,1]
示例 2:

输入: 5
输出: [0,1,1,2,1,2]

 */

class Solution {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            //一个数的比特位1的个数先让他等于他一半的比特位量
            ans[i] = ans[i / 2];
            //如果是奇数还要加1
            if ((i & 1) == 1)
                ans[i]++;
        }
        return ans;
    }
}