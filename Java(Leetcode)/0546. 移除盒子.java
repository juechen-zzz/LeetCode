/* 
给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。

你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k * k 个积分。

当你将所有盒子都去掉之后，求你能获得的最大积分和。

 

示例 1：

输入：boxes = [1,3,2,2,2,3,4,3,1]
输出：23
解释：
[1, 3, 2, 2, 2, 3, 4, 3, 1] 
----> [1, 3, 3, 4, 3, 1] (3*3=9 分) 
----> [1, 3, 3, 3, 1] (1*1=1 分) 
----> [1, 1] (3*3=9 分) 
----> [] (2*2=4 分)
示例 2：

输入：boxes = [1,1,1]
输出：9
示例 3：

输入：boxes = [1]
输出：1

 */

class Solution {
    int[][][] dp;

    public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        dp = new int[n][n][n];
        return calculate(boxes, 0, n - 1, 0);
    }

    private int calculate(int[] boxes, int left, int right, int k) {
        if (left > right) {return 0;}

        if (dp[left][right][k] == 0) {
            dp[left][right][k] = calculate(boxes, left, right - 1, 0) + (k + 1) * (k + 1);
            for (int i = left; i < right; i++) {
                if (boxes[i] == boxes[right]) {
                    dp[left][right][k] = Math.max(dp[left][right][k], calculate(boxes, left, i, k + 1) + calculate(boxes, i + 1, right - 1, 0));
                }
            }
        }

        return dp[left][right][k];
    }
}