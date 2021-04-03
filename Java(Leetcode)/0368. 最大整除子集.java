/* 
给出一个由无重复的正整数组成的集合，找出其中最大的整除子集，子集中任意一对 (Si，Sj) 都要满足：Si % Sj = 0 或 Sj % Si = 0。

如果有多个目标子集，返回其中任何一个均可。



示例 1:

输入: [1,2,3]
输出: [1,2] (当然, [1,3] 也正确)
示例 2:

输入: [1,2,4,8]
输出: [1,2,4,8]

 */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) {return new ArrayList<>();}
        Arrays.sort(nums);

        List[] dp = new List[n];
        dp[0] = new ArrayList<>();
        dp[0].add(nums[0]);

        List<Integer> ans = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = new ArrayList<>();
            dp[i].add(nums[i]);

            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i].size() < dp[j].size() + 1) {
                    dp[i] = new ArrayList(dp[j]);
                    dp[i].add(nums[i]);
                }
            }

            if (ans.size() < dp[i].size()) {ans = dp[i];}
        }

        return ans;
    }
}