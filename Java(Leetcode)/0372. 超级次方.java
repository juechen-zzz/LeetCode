/* 
你的任务是计算 ab 对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。

示例 1：

输入：a = 2, b = [3]
输出：8
示例 2：

输入：a = 2, b = [1,0]
输出：1024
示例 3：

输入：a = 1, b = [4,3,3,8,5,2]
输出：1

 */

class Solution {
    int mod = 1337;

    public int superPow(int a, int[] b) {
        int n = b.length;
        if (n == 0) {return 1;}
        int[] copy = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            copy[i] = b[i];
        }
        return simplePow(a, b[n - 1]) * (simplePow(superPow(a, copy), 10)) % mod;
    }

    private int simplePow(int a, int i) {
        if (i == 0) {return 1;}
        if(i % 2 == 1) {return (a % mod) * simplePow(a, i - 1) % mod;}
        int half = simplePow(a, i / 2) % mod;
        return (half * half) % mod;
    }
}
