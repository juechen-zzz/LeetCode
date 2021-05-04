/* 
给定数组 nums 由正整数组成，找到三个互不重叠的子数组的最大和。

每个子数组的长度为k，我们要使这3*k个项的和最大化。

返回每个区间起始索引的列表（索引从 0 开始）。如果有多个结果，返回字典序最小的一个。

示例:

输入: [1,2,1,2,6,7,5,1], 2
输出: [0, 3, 5]
解释: 子数组 [1, 2], [2, 6], [7, 5] 对应的起始索引为 [0, 3, 5]。
我们也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
注意:

nums.length的范围在[1, 20000]之间。
nums[i]的范围在[1, 65535]之间。
k的范围在[1, floor(nums.length / 3)]之间。

 */

class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] cache = new int[n - k + 1];
        int[] left = new int[n - k + 1];
        int[] right = new int[n - k + 1];

        int sum = 0;
        for (int i = 0; i < k; i++) {sum += nums[i];}
        cache[0] = sum;
        
        for (int i = 1; i < cache.length; i++) {
            int v = cache[i] = sum = sum + nums[i + k - 1] - nums[i - 1];
            if (v > cache[left[i - 1]]) {
                left[i] = i;
            }
            else {
                left[i] = left[i - 1];
            }
        }
        right[n - k] = n - k;

        for (int i = n - k - 1; i >= 0; i--) {
            if (cache[i] >= cache[right[i + 1]]) {
                right[i] = i;
            }
            else {
                right[i] = right[i + 1];
            }
        }

        int interval = k << 1;
        int[] ans = new int[]{0, k, interval};
        int max = Integer.MIN_VALUE;
        int maxM = cache.length - k;

        for (int m = k; m < maxM; m++) {
            int v = cache[left[m - k]] + cache[m] + cache[right[m + k]];
            if (v > max) {
                max = v;
                ans[0] = left[m - k];
                ans[1] = m;
                ans[2] = right[m + k];
            }
        }

        return ans;
    }
}