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
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        myMethod(nums, ans, path, 0);

        return ans;
    }

    private static void myMethod(int[] nums, List<List<Integer>> ans, List<Integer> path, int begin) {
        Collections.sort(path);
        if (!ans.contains(path)) {ans.add(new ArrayList<>(path));}
        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            myMethod(nums, ans, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}