/* 
累加数是一个字符串，组成它的数字可以形成累加序列。

一个有效的累加序列必须至少包含 3 个数。除了最开始的两个数以外，字符串中的其他数都等于它之前两个数相加的和。

给定一个只包含数字 '0'-'9' 的字符串，编写一个算法来判断给定输入是否是累加数。

说明: 累加序列里的数不会以 0 开头，所以不会出现 1, 2, 03 或者 1, 02, 3 的情况。

示例 1:

输入: "112358"
输出: true 
解释: 累加序列为: 1, 1, 2, 3, 5, 8 。1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
示例 2:

输入: "199100199"
输出: true 
解释: 累加序列为: 1, 99, 100, 199。1 + 99 = 100, 99 + 100 = 199

 */

class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3) {return false;}
        return dfs(num, num.length(), 0, 0, 0, 0);
    }

    /**
     * @param num    原始字符串
     * @param len    原始字符串长度
     * @param idx    当前处理下标
     * @param sum    前面的两个数字之和
     * @param pre    前一个数字
     * @param k      当前是处理的第几个数字
     */
    private boolean dfs(String num, int len, int idx, long sum, long pre, int k) {
        if (idx == len) {return k > 2;}

        for (int i = idx; i < len; i++) {
            long cur = getCurValue(num, idx, i);
            if (cur < 0 || (k >= 2 && cur != sum)) {continue;}
            if (dfs(num, len, i + 1, pre + cur, cur, k + 1)) {return true;}
        }
        return false;
    }

    private long getCurValue(String num, int left, int right) {
        if (left < right && num.charAt(left) == '0') {return -1;}
        long ans = 0;
        while (left <= right) {
            ans = ans * 10 + (num.charAt(left++) - '0');
        }
        return ans;
    }
}