/* 
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：

输入：nums = [0]
输出：[[],[0]]

 */

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return ans;
    }

    public void backtrack(int[] nums, int idx) {
        ans.add(new ArrayList<>(tmp));
        for (int i = idx; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}