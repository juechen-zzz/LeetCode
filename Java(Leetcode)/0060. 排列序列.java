/* 
给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。



示例 1：

输入：n = 3, k = 3
输出："213"
示例 2：

输入：n = 4, k = 9
输出："2314"

 */

class Solution {
    public String getPermutation(int n, int k) {
        k--;

        int [] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {factorial[i] = factorial[i - 1] * i;}

        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {nums.add(i);}

        StringBuilder ans = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            ans.append(nums.remove(index));
            k -= index * factorial[i];
        }

        return ans.toString();
    }
}
