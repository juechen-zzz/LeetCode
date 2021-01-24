/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/

// 回溯
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, ans, track);
        return ans;
    }

    public void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> track) {
        if (track.size() == nums.length) {
            ans.add(new ArrayList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (track.contains(nums[i])) {continue;}
            track.add(nums[i]);
            backtrack(nums, ans, track);
            track.remove(track.size() - 1);
        }
    }
}