/* 
实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须 原地 修改，只允许使用额外常数空间。

 

示例 1：

输入：nums = [1,2,3]
输出：[1,3,2]
示例 2：

输入：nums = [3,2,1]
输出：[1,2,3]
示例 3：

输入：nums = [1,1,5]
输出：[1,5,1]
示例 4：

输入：nums = [1]
输出：[1]

 */

class Solution {
    public void nextPermutation(int[] nums) {
        int index = nums.length - 1;
        while (index >= 1) {
            if (nums[index - 1] >= nums[index]) {
                index--;
            }
            else {break;}
        }

        if (index > 0) {
            int left = index - 1;
            int right = nums.length - 1;
            while (nums[left] >= nums[right]) {
                right--;
            }
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            Arrays.sort(nums, index, nums.length);
        }
        else {
            Arrays.sort(nums);
        }
        return;
    }
}
