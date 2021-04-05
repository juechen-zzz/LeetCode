/* 
给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是 2 。

 

示例：

输入：[4, 6, 7, 7]
输出：[[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 

提示：

给定数组的长度不会超过15。
数组中的整数范围是 [-100,100]。
给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。

 */

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        dfs(nums, 0, Integer.MIN_VALUE);
        return ans;
    }

    private void dfs(int[] nums, int cur, int end) {
        if (cur == nums.length) {
            if (tmp.size() >= 2) {
                ans.add(new ArrayList<>(tmp));
            }
            return;
        }

        // 使序列合法的办法非常简单，即给「选择」做一个限定条件，只有当前的元素大于等于上一个选择的元素的时候才能选择这个元素，这样枚举出来的所有元素都是合法的
        if (nums[cur] >= end) {
            tmp.add(nums[cur]);
            dfs(nums, cur + 1, nums[cur]);
            tmp.remove(tmp.size() - 1);
        }

        // 那如何保证没有重复呢？我们需要给「不选择」做一个限定条件，只有当当前的元素不等于上一个选择的元素的时候，才考虑不选择当前元素，直接递归后面的元素。
        if (nums[cur] != end) {
            dfs(nums, cur + 1, end);
        }
    }
}
