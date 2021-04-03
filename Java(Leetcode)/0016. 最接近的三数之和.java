/* 
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 

示例：

输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 

 */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++){
            if (i > 0 && nums[i] == nums[i - 1]) {continue;}
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int total = nums[i] + nums[left] + nums[right];
                if (Math.abs(total - target) < Math.abs(ans - target)){ans = total;}
                if (total - target < 0) {
                    while (left < right && nums[left] == nums[left + 1]) {left++;}
                    left++;
                }
                else if (total - target > 0) {
                    while (left < right && nums[right] == nums[right - 1]) {right--;}
                    right--;
                }
                else {break;}
            }
        }
        return ans;
    }
}