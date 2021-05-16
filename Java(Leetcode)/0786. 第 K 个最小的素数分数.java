/* 
给你一个按递增顺序排序的数组 arr 和一个整数 k 。数组 arr 由 1 和若干 素数  组成，且其中所有整数互不相同。

对于每对满足 0 < i < j < arr.length 的 i 和 j ，可以得到分数 arr[i] / arr[j] 。

那么第 k 个最小的分数是多少呢?  以长度为 2 的整数数组返回你的答案, 这里 answer[0] == arr[i] 且 answer[1] == arr[j] 。

 
示例 1：

输入：arr = [1,2,3,5], k = 3
输出：[2,5]
解释：已构造好的分数,排序后如下所示: 
1/5, 1/3, 2/5, 1/2, 3/5, 2/3
很明显第三个最小的分数是 2/5
示例 2：

输入：arr = [1,7], k = 1
输出：[1,7]

 */

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double low = 0, high = 1;
        int[] ans = new int[]{0, 1};

        while (high - low > 1e-9) {
            double mid = low + (high - low) / 2.0;
            int[] cur = myMethod(mid, arr);

            if (cur[0] < k) {
                low = mid;
            }
            else {
                ans[0] = cur[1];
                ans[1] = cur[2];
                high = mid;
            }
        }

        return ans;
    }

    // 用来求解小于x的分数数量以及最大的那个分数的分子和分母
    public int[] myMethod(double x, int[] arr) {
        int left = 0, right = 1, count = 0, i = -1;
        for (int j = 1; j < arr.length; j++) {
            while (arr[i+1] < arr[j] * x) {i++;}

            count += i+1;
            if (i >= 0 && left * arr[j] < right * arr[i]) {
                left = arr[i];
                right = arr[j];
            }
        }
        return new int[]{count, left, right};
    }
}