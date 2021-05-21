/* 
给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]
示例 2：

输入：candidates = [2,3,5], target = 8,
所求解集为：
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]

 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        myMethod(candidates, target, ans, path, 0, 0);
        return ans;
    }

    private static void myMethod(int[] candidates, int target, List<List<Integer>> ans, List<Integer> path, int sum, int begin) {
        if (sum == target) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            int curSum = sum + candidates[i];
            if (curSum <= target) {
                path.add(candidates[i]);
                myMethod(candidates, target, ans, path, curSum, i);
                path.remove(path.size() - 1);
            }
            else {break;}
        }
    }
}