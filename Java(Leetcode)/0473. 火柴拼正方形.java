/* 
还记得童话《卖火柴的小女孩》吗？现在，你知道小女孩有多少根火柴，请找出一种能使用所有火柴拼成一个正方形的方法。不能折断火柴，可以把火柴连接起来，并且每根火柴都要用到。

输入为小女孩拥有火柴的数目，每根火柴用其长度表示。输出即为是否能用所有的火柴拼成正方形。

示例 1:

输入: [1,1,2,2,2]
输出: true

解释: 能拼成一个边长为2的正方形，每边两根火柴。
示例 2:

输入: [3,3,3,3,4]
输出: false

解释: 不能用所有火柴拼成一个正方形。

 */

class Solution {
    public boolean makesquare(int[] nums) {
        int sum = 0;
        for (int n : nums) {sum += n;}
        if (sum == 0 || sum % 4 != 0) {return false;}
        return myMethod(nums, sum >> 2, new int[4], 0);
    }

    private static boolean myMethod(int[] nums, int target, int[] edges, int index) {
        if (index == nums.length) {
            if (edges[0] == edges[1] && edges[1] == edges[2] && edges[2] == edges[3]) {return true;}
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (edges[i] + nums[index] > target) {continue;}

            edges[i] += nums[index];
            if (myMethod(nums, target, edges, index + 1)) {return true;}
            edges[i] -= nums[index];
        }

        return false;
    }
}