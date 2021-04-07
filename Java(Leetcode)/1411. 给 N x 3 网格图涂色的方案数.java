/* 
你有一个 n x 3 的网格图 grid ，你需要用 红，黄，绿 三种颜色之一给每一个格子上色，且确保相邻格子颜色不同
（也就是有相同水平边或者垂直边的格子颜色不同）。

给你网格图的行数 n 。

请你返回给 grid 涂色的方案数。由于答案可能会非常大，请你返回答案对 10^9 + 7 取余的结果。

示例 1：

输入：n = 1
输出：12
解释：总共有 12 种可行的方法：

示例 2：

输入：n = 2
输出：54
 */


class Solution {
    public int numOfWays(int n) {
        long dp2 = 6, dp3 = 6, mod = 1000000007;
        for(int i = 1; i < n; i++) {
            long temp2 = dp2;
            long temp3 = dp3;
            // 若当前使用 2 种颜色组成网格
            // 如果上一个网格是 2 种颜色，则当前网格有 3 种可能
            // 如果上一个网格是 3 种颜色，则当前网格有 2 种可能
            dp2 = (temp2 * 3 % mod + temp3 * 2 % mod) % mod;
            // 若当前使用 3 种颜色组成网格
            // 如果上一个网格是 2 种颜色，则当前网格有 2 种可能
            // 如果上一个网格是 3 种颜色，则当前网格有 2 种可能
            dp3 = (temp2 * 2 % mod + temp3 * 2 % mod) % mod;
        }
        return (int)((dp2 + dp3) % mod);
    }
}
