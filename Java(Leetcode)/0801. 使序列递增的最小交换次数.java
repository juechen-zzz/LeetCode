/* 
我们有两个长度相等且不为空的整型数组 A 和 B 。

我们可以交换 A[i] 和 B[i] 的元素。注意这两个元素在各自的序列中应该处于相同的位置。

在交换过一些元素之后，数组 A 和 B 都应该是严格递增的（数组严格递增的条件仅为A[0] < A[1] < A[2] < ... < A[A.length - 1]）。

给定数组 A 和 B ，请返回使得两个数组均保持严格递增状态的最小交换次数。假设给定的输入总是有效的。

示例:
输入: A = [1,3,5,4], B = [1,2,3,7]
输出: 1
解释: 
交换 A[3] 和 B[3] 后，两个数组如下:
A = [1, 3, 5, 7] ， B = [1, 2, 3, 4]
两个数组均为严格递增的。

 */

class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int ans = 0;
        int n = nums1.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = 1;

        for (int i = 1; i < n; i++) {
            if (nums1[i - 1] < nums1[i] && nums2[i - 1] < nums2[i]) {
                if (nums1[i - 1] < nums2[i] && nums2[i - 1] < nums1[i]) {
                    dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
                    dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + 1;
                }
                else {
                    dp[i][0] = dp[i - 1][0];
                    dp[i][1] = dp[i - 1][1] + 1;
                }
            }
            else {
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = dp[i - 1][0] + 1;
            }
        }

        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }
}