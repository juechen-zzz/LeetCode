/* 
编写一段程序来查找第 n 个超级丑数。

超级丑数是指其所有质因数都是长度为 k 的质数列表 primes 中的正整数。

示例:

输入: n = 12, primes = [2,7,13,19]
输出: 32 
解释: 给定长度为 4 的质数列表 primes = [2,7,13,19]，前 12 个超级丑数序列为：[1,2,4,7,8,13,14,16,19,26,28,32] 。
说明:

1 是任何给定 primes 的超级丑数。
 给定 primes 中的数字以升序排列。
0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000 。
第 n 个超级丑数确保在 32 位有符整数范围内。

 */

class Solution {
    public class SuperUglyNumber {
        public int nthSuperUglyNumber(int n, int[] primes) {
            int len = primes.length;
            int dp[] = new int[n];
            dp[0] = 1;
            /*梳理一下思路，dp[i]保存的是第i个超级丑数*/
            /*index[i]表示的是primes里面的第i个数下一个将要相乘的数在dp中的位置，
            反过来想，对于每个primes来说，我们都需要和dp中已经算出来的结果相乘算，
            然后取最小的那个作为新的dp元素
            索引index实际上表示是这个素数已经和dp中的哪个位置结合了，下一个位置的坐标是多少 */
            int index[] = new int[len];
            /*可能存在重复的丑数，所以呢，不要在for循环里面加break，把所有的情况都+1*/
            for (int i = 1; i < n; i++) {
                int min = Integer.MAX_VALUE;
                /*遍历对比一下值，找出最小的，*/
                for (int j = 0; j < len; j++) {
                    if (min > primes[j] * dp[index[j]]) {
                        min = primes[j] * dp[index[j]];//这个地方就是当前质因数和他要结合的dp
                    }
                }
                dp[i] = min;
                /*那个素数要乘以dp的坐标index要加1，向后推一个位
                * 如果存在重复的值，也就是说不同的质因数相乘，得出来相同的结果了，
                * 我们就把这几个位置都+1，这样就可以避免出现重复的值了。
                * 你想想，假如你找到了对应的素数的index，把它加1之后就break掉，那么后面的数也可以算出这个结果，
                * 下次循环的时候，势必会把这个重复的数当成下一个dp，因为这个数肯定要比下一个丑数小
                * 所以我们在for循环中不要加break；*/
                for (int j = 0; j < len; j++) {
                    if (min == primes[j] * dp[index[j]]) {
                        index[j]++;
                    }
                }

            }
            return dp[n - 1];
        }
    }
}