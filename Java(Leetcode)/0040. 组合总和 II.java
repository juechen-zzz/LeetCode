/* 
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 */

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        backtrack(candidates, target, ans, track, 0, 0);
        return ans;
    }

    public void backtrack(int[] candidates, int target, List<List<Integer>> ans, List<Integer> track, int sum, int begin) {
        if (sum == target) {
            ans.add(new ArrayList(track));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) {continue;}
            int curSum = candidates[i] + sum;
            if (curSum <= target) {
                track.add(candidates[i]);
                backtrack(candidates, target, ans, track, curSum, i + 1);
                track.remove(track.size() - 1);
            }
            else {
                break;
            }
        }
    }
}