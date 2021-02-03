/* 
给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

 */

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> tmp = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return ans;
    }

    public void backtrack(int[] nums, int idx) {
        Collections.sort(tmp);
        if (!ans.contains(tmp)) {ans.add(new ArrayList<>(tmp));}
        for (int i = idx; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrack(nums, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}