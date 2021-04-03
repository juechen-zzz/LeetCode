/* 
我们正在玩一个猜数游戏，游戏规则如下：

我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。

每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。

然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。

示例:

n = 10, 我选择了8.

第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。

游戏结束。8 就是我选的数字。

你最终要支付 5 + 7 + 9 = 21 块钱。

 */

class Solution {
    public int getMoneyAmount(int n) {
        if (n == 1) {return 0;}
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = i - 1; j > 0; j--) {
                int min = Integer.MAX_VALUE, left = 0, right = 0;
                for (int k = i; k > j - 1; k--) {
                    left = (k == j || j == k - 1) ? -1 : dp[k - 1][j];
                    right = (k == i || i == k + 1) ? -1 : dp[i][k + 1];
                    min = (left == -1 && right == -1) ? k : Math.min(min, k + Math.max(left, right));
                }
                dp[i][j] = min;
            }
        }
        return dp[n][1];
    }
}