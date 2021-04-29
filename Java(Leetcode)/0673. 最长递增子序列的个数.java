/* 
给定一个未排序的整数数组，找到最长递增子序列的个数。

示例 1:

输入: [1,3,5,4,7]
输出: 2
解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
示例 2:

输入: [2,2,2,2,2]
输出: 5
解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。

 */

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        if (n <= 1) {return n;}
        int[] length = new int[n];
        int[] count = new int[n];
        Arrays.fill(count, 1);

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                if (nums[i] < nums[j]) {
                    if (length[i] >= length[j]) {
                        length[j] = length[i] + 1;
                        count[j] = count[i];
                    }
                    else if (length[i] + 1 == length[j]) {
                        count[j] += count[i];
                    }
                }
            }
        }

        int longest = 0, ans = 0;
        for (int l : length) {longest = Math.max(longest, l);}
        for (int i = 0; i < n; i++) {
            if (length[i] == longest) {
                ans += count[i];
            }
        }
        
        return ans;
    }
}