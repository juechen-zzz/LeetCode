/* 
给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。

注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。

 

示例 1：

输入：n = 12
输出：21
示例 2：

输入：n = 21
输出：-1

 */


class Solution {
    public int nextGreaterElement(int n) {
        char[] nums = ("" + n).toCharArray();
        int left = nums.length - 2;
        while (left >= 0 && nums[left] >= nums[left + 1]) {left--;}
        if (left < 0) {return -1;}

        int right = nums.length - 1;
        while (right >= 0 && nums[left] >= nums[right]) {right--;}

        swap(nums, left, right);
        reverse(nums, left + 1);

        try {
            return Integer.parseInt(new String(nums));
        } catch (Exception e) {
            return -1;
        }
    }

    private void swap(char[] nums, int left, int right) {
        char tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }

    private void reverse(char[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}