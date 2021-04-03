/* 
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。


示例 1：

输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：

输入：nums = [0,1,0,3,2,3]
输出：4
示例 3：

输入：nums = [7,7,7,7,7,7,7]
输出：1

 */

// DP
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

// 二分
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];
        
        int piles = 0;
        for (int i = 0; i < nums.length; i++){
            int poker = nums[i];

            int left = 0, right = piles;
            while (left < right){
                int mid = (left + right) / 2;
                if (top[mid] > poker){
                    right = mid;
                } else if (top[mid] < poker){
                    left = mid + 1;
                }else {
                    right = mid;
                }
            }

            if (left == piles) {piles++;}
            top[left] = poker;
        }
        return piles;
    }
}