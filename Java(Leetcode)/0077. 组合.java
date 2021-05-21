/* 
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {nums[i] = i + 1;}

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        myMethod(nums, k, ans, path, 0);

        return ans;
    }

    private static void myMethod(int[] nums, int k, List<List<Integer>> ans, List<Integer> path, int begin) {
        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < nums.length; i++) {
            path.add(nums[i]);
            myMethod(nums, k, ans, path, i + 1);
            path.remove(path.size() - 1);
        }
    }
}