/* 
给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。

示例 1：

输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
输出： True
说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。

 */
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {sum += num;}
        if (sum % k != 0) {return false;}
        int target = sum / k;
        Arrays.sort(nums);

        int row = nums.length - 1;
        if (nums[row] > target) {return false;}
        //排除掉nums中与target相同的值。
        while (row >= 0 && nums[row] == target) {
            row--;
            k--;
        }
        return search(new int[k], row, nums, target);
    }

    public boolean search(int[] groups, int row, int[] nums, int target) {
        if (row < 0) {return true;}
        // 取出剩下最大的数。
        int v = nums[row--];
        for (int i = 0; i < groups.length; i++) {
            // 放入到总和还未大于等于target的group[i]中
            if (groups[i] + v <= target) {
                groups[i] += v;
                // 递归，继续取出一个数。
                if (search(groups, row, nums, target)) {return true;}
                // 递归结束后，有两种情况：
                // 1. 所有的数都被取出（row为-1返回true）
                // 2. 其中一次返回了false，说明这种放置方法不能满足正好全部放入，则执行以下代码逻辑。

                //group[i]取出这个数，进入下一次循环，放到另一个group[i+1]中。
                groups[i] -= v;
            }
            // 如果group[i]==0，则表示：
            // 该group从未放入过除了 v 以外的其他东西 但是依旧放入失败了，说明 v 无论怎样放置都会失败。
            // 于是，跳出循环返回false
            if (groups[i] == 0) {break;}
        }
        return false;
    }
}